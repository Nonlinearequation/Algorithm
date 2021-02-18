package 数据结构实现.大话数据结构.队列;

/**
 * 循环队列
 *
 * @param <E>
 */
public class Queue<E> implements QueueI<E> {

    private Object[] data;

    //头指针
    private int front;

    //空闲位置指针
    private int rear;

    private final int DEFAULT_CAPACITY = 10;

    //数组整体长度
    private int length;

    @Override
    public void initQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("长度必须大于0");
        }
        front = 0;
        rear = 0;
        data = new Object[capacity];
        length = capacity;
    }

    @Override
    public void destroyQueue() {
        clearQueue();
        data = null;
    }

    @Override
    public void clearQueue() {
        for (int i = 0; i < data.length; i++) {
            data[i] = null;
        }
    }

    @Override
    public E getHead() {
        if(empty()){
            throw new NullPointerException("队列为空");
        }
        E e  = (E) data[front];
        front = (front+1)%length;
        return e;
    }

    @Override
    public boolean enQueue(E e) {
        if (full()) {
            throw new ArrayStoreException("队列已满");
        }
        data[rear] = e;
        rear = (rear + 1) % length;//若rear在数组最后一个元素，则更新rear=0
        return true;
    }

    @Override
    public E deleteQueue() {
        return null;
    }

    @Override
    public int size() {
        return (rear - front + length) % length;
    }

    /**
     * 判断队列是否已满
     *
     * @return
     */
    private boolean full() {
        return (rear + 1) % length == front;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean empty() {
        return rear == front;
    }
}

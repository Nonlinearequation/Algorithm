package 数据结构实现.大话数据结构.队列;

public interface QueueI<E> {

    void initQueue(int capacity);//初始化

    void destroyQueue();//若队列存在，销毁

    void clearQueue();//清空队列

    E getHead();//若队列存在，返回队头元素

    boolean enQueue(E e);//若队列存在，在队尾插入元素

    E deleteQueue();//删除队头元素，并返回值

    int size();//返回长度




}

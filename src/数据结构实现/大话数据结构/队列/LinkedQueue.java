package 数据结构实现.大话数据结构.队列;

public class LinkedQueue<E> implements QueueI<E> {

    private Node<E> first;//首节点

    private Node<E> last;//末节点

    private int size = 0;//队列长度

    @Override
    public void initQueue(int capacity) {
        //链式存储不需要固定长度
    }

    @Override
    public void destroyQueue() {

    }

    @Override
    public void clearQueue() {
        Node<E> node = first;
        for (; !empty(); ) {
            if (node != null) {
                node.e = null;
                node.prev = null;
            }
            node = node.next;

        }
    }

    @Override
    public E getHead() {
        if (first == null) {
            throw new NullPointerException("队列为空");
        }
        if (first.next == null) {
            E e = first.e;
            first = null;
            return e;
        }
        Node<E> node = first;
        first = node.next;
        first.prev = null;
        node.next = null;
        size--;
        return node.e;
    }

    @Override
    public boolean enQueue(E e) {
        if (empty()) {
            Node<E> node = new Node<E>(null, e, null);
            first = node;
        } else if (first.next == null) {
            Node<E> node = new Node<E>(first, e, null);
            first.next = node;
            last = node;
        } else {
            Node<E> node = new Node<E>(last, e, null);
            last.next = node;
            last = node;
        }
        size++;
        return true;
    }

    @Override
    public E deleteQueue() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

}

class Node<E> {
    E e;
    Node<E> prev;
    Node<E> next;

    public Node(Node<E> prev, E e, Node<E> next) {
        this.e = e;
        this.prev = prev;
        this.next = next;
    }
}

package 数据结构实现.大话数据结构.树;

public class Node<E> {

    E data;
    int parent;

    public Node(E data, int parent) {
        this.data = data;
        this.parent = parent;
    }

    public Node() {
    }
}

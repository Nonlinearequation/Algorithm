package 数据结构实现.大话数据结构.栈;

/**
 * 栈的链式存储结构
 */
public class LinkedStack<E> {

    Node<E> last;

    /**
     * 数量
     */
    int count;

    /***
     * 查找最先入栈的元素
     * @return
     */
    private Node<E> findLast() {
        Node<E> node = (Node<E>) last.next;
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    /**
     * 入栈
     *
     * @param element
     */
    public void push(E element) {
        Node<E> newLast = null;
        if (this.last == null) {
            newLast = new Node<E>(null, element, null);
        } else {
            newLast = new Node<E>(null, element, this.last);
            last.prev = newLast;
        }
        this.last = newLast;
        count++;
    }

    /**
     * 出栈
     *
     * @return
     */
    public E pop() {
        if(last==null){
            throw new NullPointerException("栈为空");
        }
        E e = last.element;
        //释放对象
        last.element = null;
        //弹出一个元素后，倒数第二入栈的元素变为last
        Node<E> next = last.next;
        last.next = null;
        //如果不是第一个入栈的元素，删除与下一个元素的关联
        if(next!=null) {
            next.prev = null;
        }
        this.last = next;
        return e;
    }

    public boolean empty() {
        return last == null;
    }

}

class Node<E> {
    E element;
    /**后于e入栈的元素*/
    Node<E> prev;
    /**先于e入栈的元素*/
    Node<E> next;

    Node(Node<E> prev, E element, Node<E> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }
}
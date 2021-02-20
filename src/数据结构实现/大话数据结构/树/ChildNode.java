package 数据结构实现.大话数据结构.树;


/**
 * 链表形式存储关系
 * @author xi553
 */
public class ChildNode {

    /**
     * 子节点索引
     */
    private int child;

    /**
     * 下一个子节点
     */
    private ChildNode next;

    public ChildNode(int child, ChildNode next) {
        this.child = child;
        this.next = next;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public ChildNode getNext() {
        return next;
    }

    public void setNext(ChildNode next) {
        this.next = next;
    }
}

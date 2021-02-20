package 数据结构实现.大话数据结构.树;

/**
 * 数据节点
 * @author xi553
 */
public class BoxNode{

    /**
     * 数据
     */
    private Object data;

    /**
     * 第一个子节点
     */
    private ChildNode firstChild;

    /**
     * 双亲索引
     */
    private Integer parent;

    public BoxNode(Object data, ChildNode firstChild, Integer parent) {
        this.data = data;
        this.firstChild = firstChild;
        this.parent = parent;
    }

    public BoxNode(Object data, Integer parent) {
        this.data = data;
        this.parent = parent;
    }

    public BoxNode(Object data) {
        this.data = data;
    }

    public BoxNode() {
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ChildNode getFirstChild() {
        return firstChild;
    }

    public void setFirstChild(ChildNode firstChild) {
        this.firstChild = firstChild;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }
}

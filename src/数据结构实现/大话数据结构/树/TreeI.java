package 数据结构实现.大话数据结构.树;

/**
 * 树接口
 * 有三种节点的表示方法：双亲表示法、孩子表示法、孩子兄弟表示法
 */
public interface TreeI<E> {

    /**
     * 初始化
     */
    void initTree();

    /**
     * @param data 数据
     * @param parent 双亲的索引
     */
    void insertChild(Object data, int parent);

    Node parent(Node node);

}

package 数据结构实现.大话数据结构.树;

/**
 * 双亲表示法
 * 数组表示树结构，数据是Node(数据data,双亲下标)
 * @author xi553
 */
public class Tree<E> implements TreeI<E>{

    private Node[] tree;

    private static final int DEFAULT_CAPACITY = 10;

    private int cur;//下一个位置的指针

    @Override
    public void initTree() {
        tree = new Node[DEFAULT_CAPACITY];
        cur = 0;
    }

    /**
     * 增加子节点
     * @param data 数据
     * @param parent 双亲的索引
     */
    @Override
    public void insertChild(Object data, int parent) {
        if(data != null){
            tree[cur++] = new Node<E>((E) data,parent);
        }
    }

    /**
     * 获取树的双亲节点
     * @param node
     * @return
     */
    @Override
    public Node parent(Node node) {
        return tree[node.parent];
    }

}

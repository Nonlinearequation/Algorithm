package 数据结构实现.大话数据结构.树;


import java.util.Arrays;

/**
 * 双亲孩子表示法：数组存储节点，链表存储孩子双亲节点关系
 * 树存储BoxNode
 * BoxNode存储数据和关系
 *
 * @author xi553
 */
public class Tree2 implements TreeI {

    /**
     * 第一列是BoxNode；第二列是parent索引，用来指向双亲位置
     */
    private BoxNode[] tree;

    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 下一个位置指针
     */
    private int cur;


    @Override
    public void initTree() {
        tree = new BoxNode[DEFAULT_CAPACITY];
        cur = 0;
    }

    public void initTree(int capacity) {
        tree = new BoxNode[capacity];
    }

    /**
     * 第一列是数据BoxNode，第二列是双亲位置索引。
     * 数据插入tree，还要将双亲孩子关系加入双亲的链表
     *
     * @param data   数据
     * @param parent 双亲的索引
     */
    @Override
    public void insertChild(Object data, int parent) {
        ensureExplicitCapacity();
        tree[cur] = new BoxNode(data, parent);
        //根节点没有双亲，不需要向双亲添加子节点
        if (parent != -1) {
            BoxNode parentNode = tree[parent];
            ChildNode child = parentNode.getFirstChild();
            ChildNode childNode = new ChildNode(cur, null);
            if (child == null) {
                parentNode.setFirstChild(childNode);
            } else {
                while (child.getNext() != null) {
                    child = child.getNext();
                }
                child.setNext(childNode);
            }
        }
        cur++;
    }

    private void ensureExplicitCapacity() {
        if (tree.length-1 >= cur) {
            //不扩容
        } else {
            int oldCapacity = tree.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            grow(newCapacity);
        }
    }

    private void grow(int capacity){
        tree = Arrays.copyOf(tree,capacity);
    }

    @Override
    public Node parent(Node node) {
        return null;
    }

    public BoxNode parent(BoxNode boxNode) {
        int index = 0;
        while (index < cur) {
            if (boxNode.getData().equals(tree[index].getData())) {
                return tree[tree[index].getParent()];
            }
            index++;
        }
        return null;
    }

}

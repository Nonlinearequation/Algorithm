package 数据结构实现.大话数据结构.树;

/**
 * 邓俊辉树算法实现
 * @author xi553
 */
public class TreeLinkedList {

    //根节点
    private Object data;

    //父亲、长子和最大的弟弟
    private TreeLinkedList parent,firstChild,nextSibling;

    public TreeLinkedList() {
        this(null,null,null,null);
    }

    public TreeLinkedList(Object data, TreeLinkedList parent, TreeLinkedList firstChild, TreeLinkedList nextSibling) {
        this.data = data;
        this.parent = parent;
        this.firstChild = firstChild;
        this.nextSibling = nextSibling;
    }

    /***
     * 将数据存入当前节点，并返回原先的数据
     * @param o
     */
    public Object setData(Object o) {
        Object old = data;
        this.data = o;
        return old;
    }

    public Object getData() {
        return data;
    }

    public TreeLinkedList getParent() {
        return parent;
    }

    public TreeLinkedList getFirstChild() {
        return firstChild;
    }

    public TreeLinkedList getNextSibling() {
        return nextSibling;
    }

    public void setParent(TreeLinkedList parent) {
        this.parent = parent;
    }

    public void setFirstChild(TreeLinkedList firstChild) {
        this.firstChild = firstChild;
    }

    public void setNextSibling(TreeLinkedList nextSibling) {
        this.nextSibling = nextSibling;
    }

    /***
     * 返回当前节点后代的数目，即以当前节点为根的子树规模
     * 一棵树的规模等于根节点下所有子树规模之和再加一   以下方法通过firstchild找到根节点的长子，累加子树规模，
     * 再顺着nextSibling找到其余的子树，递归地计算子树规模。时间复杂度为O(n)
     * @return
     */
    public int getSize(){
        int size = 1;//当前节点也是自己的后代
        TreeLinkedList child = firstChild;
        while(child != null){
            int childSize = child.getSize();
            size += childSize;
            child = child.getNextSibling();
        }
        return size;
    }

    /**
     * 获取节点的高度
     * hight(v) = max(hight(u)) + 1 (u是v的孩子)
     * 因此，通过firstChild找到根节点的长子，取得子树的最大高度，再遍历其他子节点，取得子树的最大高度
     * 递归地计算出各子树的高度，然后只要找到所有子树的最大高度，再累加计入根节点
     * @return int
     */
    public int getHeight(){
        //循环计算子树的高度，比较拿到最大值
        TreeLinkedList child = firstChild;
        int height = -1;//只有一个节点时，高度为0；如果有两个节点（父子），深度为1
        while(child != null){
            height = Math.max(height,child.getHeight());//所有孩子中取最大高度
            child = child.getNextSibling();
        }
        return height+1;//节点本身高度为1
    }

    /***
     * 获取当前节点的深度
     * 若u是v的子,则depth(u) = depth(v) + 1
     * 这里可以使用递归或迭代实现，以下使用迭代。依次找到每个节点的双亲，直到双亲为null
     * @return int
     */
    public int getDepth(){
        int depth = 0;
        TreeLinkedList parent = getParent();
        while(parent != null){
            depth++;
            parent = parent.getParent();
        }
        return depth;
    }

    /***
     * 前序遍历（根-左-右）
     * 使用递归遍历，对任何一棵树来说，先打印根节点，再打印左节点，再找左的子节点
     */
    public void preOrderTraversal(TreeLinkedList tree){
        if(data == null){
            return;
        }
        System.out.print(tree.getData());
        for(TreeLinkedList u = tree.getFirstChild();u!=null;u = u.getNextSibling()){
            preOrderTraversal(u);
        }
    }

    /**
     * 后序遍历
     * @param tree
     */
    public void postorderIterator(TreeLinkedList tree){
        if(tree == null){
            return;
        }
        for(TreeLinkedList u = tree.getFirstChild();u!=null;u = u.getNextSibling()){
            postorderIterator(u);
        }
        System.out.print(tree.getData());
    }

    /**
     * 层次遍历
     * @param tree
     */
    public void levelOrderTraversal(TreeLinkedList tree){

    }


}

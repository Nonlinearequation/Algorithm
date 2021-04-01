package 数据结构实现.大话数据结构.树;

/**
 * 二叉查找树-思路来自五分钟学算法
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private class Node {
        private E e;//节点元素值
        private Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;//根节点
    private int size;//树中元素的个数

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public void add(E e){
        root = add(root,e);//为了添加根元素不出错
    }

    /**
     * 添加元素，递归查找添加元素的位置。左子树的节点都比根节点小，右子树的节点都比根节点大
     * @param node
     * @param e 实现comparable接口的
     * @return
     */
    private Node add(Node node, E e) {
        if(node == null){//如果node为空，意味着已经找到了可以插入的节点
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e)<0){//如果插入节点小于当前节点，向当前节点的左子树添加节点
            node.left = add(node.left,e);//递归调用add方法，查找左子树，直到节点的子节点为空，返回node。此时退出本层递归，返回的node就是父节点的左/右子节点
        }else{
            node.right = add(node.right,e);//如果插入节点大于当前节点，向当前节点的右子树添加节点
        }
        return node;
    }

    /**
     * 删除节点，在左子树中找到最大的子节点，移到被删除的位置上
     */
    private void remove(E e){
        root = remove(root,e);//为了删除根元素
    }

    /**
     * 删除元素，递归查找删除元素的位置。如果删除元素小于当前节点，查找左子树；如果大于当前节点，查找右子树。
     * 删除时，1 如果被删除节点的后代为空，直接删除；2 如果只有一个后代，移动到被删除元素的位置；
     * 3 有多个后代，在左子树中找到最大的子节点，或在右子树找到最小的子节点，移动到被删除元素的位置。
     * 如果最终未找到元素，返回最接近的节点。
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node, E e) {
        if(node == null){
            return null;
        }
        if(e.compareTo(node.e)<0){//元素e小于当前节点，查找左子树
            node.left = remove(node.left,e);//递归查找左子树，如果子节点返回null，则赋值左节点为null（删除）
            return node;
        }else if(e.compareTo(node.e)>0){//元素e大于当前节点，查找右子树
            node.right = remove(node.right,e);
            return node;
        }else{//相等，删除元素
            //分情况处理，删除节点无子节点直接删除
            if(node.left == null && node.right == null){
                node = null;
                return null;
            }else if(node.left == null){//只有一个子节点，直接移动到被删除元素的位置
                Node temp = node.right;
                node.right = null;
                node = null;
                return temp;
            }else if(node.right == null){
                Node temp = node.left;
                node.left = null;
                node = null;
                return temp;
            }else{//有多个子节点，在左子树里找到最大的元素放到被删除元素的位置
                Node temp = maxNode(node.left);//在左子树里找最大的
                temp.right = node.right;
                temp.left = removeMaxNode(node.left);
                return temp;
            }
        }
    }

    /**
     * 移除最大子节点，找到最大子节点并删除，然后将它返回出去。如果最大子节点有左子树，令左子树占最大字节的位置。
     * @param left
     * @return
     */
    private Node removeMaxNode(Node left) {
        Node maxNode = maxNode(left);


        return null;
    }

    /**
     * 找最大的节点，那就是找最底层最右边的子节点
     * @param left
     * @return
     */
    private Node maxNode(Node left) {
        Node node = left;
        while(node.right!=null){
            node = node.right;
        }
        return node;
    }


    /**
     * 中序遍历，node是根节点
     * @param node
     */
    private void inOrderTraverse(Node node){
        if(node == null){
            return;
        }
        inOrderTraverse(node.left);
        System.out.print(node.e + " ");
        inOrderTraverse(node.right);
    }

    /** 递归实现
     * 在树中搜索元素e，如果找到则返回找到的节点，如果没找到返回最后遍历的节点
     * @param node
     * @return
     */
    private Node binSearch(Node node,E e){
        Node find = null;
        if(e.compareTo(node.e)<0){//目标值比当前节点小，查找左子树
            if(node.left!=null) {
                find = binSearch(node.left, e);
            } else {
                return node;
            }
        }else if(e.compareTo(node.e)>0){//目标节点比当前节点大，查找右子树
            if(node.right!=null) {
                find = binSearch(node.right, e);
            }else{
                return node;
            }
        }else{//查找命中
            return node;
        }
        return find;
    }

    /**
     * 迭代版实现
     * @param node
     * @param e
     * @return
     */
    private Node binSearchByLoop(Node node,E e){
        Node find = null;
        while(find == null){
            if(e.compareTo(node.e)<0){//目标值比当前节点小，查找左子树
                if(node.left==null) {
                    return node;
                }
                node = node.left;
            }else if(e.compareTo(node.e)>0){//目标节点比当前节点大，查找右子树
                if(node.right==null) {
                    return node;
                }
                node = node.right;
            }else{//查找命中
                find = node;
            }
        }
        return find;
    }


    public static void main(String[] args) {
        /**
         *               15
         *            /     \
         *           9      23
         *         /   \    /  \
         *        3    12  17  28
         *      /  \   /
         *     1   4  8
         */
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(15);
        bst.add(9);
        bst.add(23);
        bst.add(3);
        bst.add(12);
        bst.add(1);
        bst.add(8);
        bst.add(4);
        bst.add(17);
        bst.add(28);
        System.out.print("中序遍历：");
        bst.inOrderTraverse(bst.root);
        System.out.println("\n查找元素（递归）：" + bst.binSearch(bst.root,55).e);
        System.out.println("查找元素（迭代）：" + bst.binSearchByLoop(bst.root,4).e);


    }
}

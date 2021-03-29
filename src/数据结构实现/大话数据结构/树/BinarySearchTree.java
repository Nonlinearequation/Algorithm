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
            node.left = add(node.left,e);
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
     * 删除元素，递归查找删除元素的位置。如果删除元素小于当前节点，查找左子树；如果大于当前节点，查找右子树
     * 如果最终未找到元素，返回最接近的节点
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node, E e) {
        if(node == null){
            return null;
        }
        if(e.compareTo(node.e)<0){//元素e小于当前节点，查找左子树
            node = remove(node.left,e);
            return node;
        }else if(e.compareTo(node.e)>0){//元素e大于当前节点，查找右子树
            node = remove(node.right,e);
            return node;
        }else{//相等，删除元素
            //分情况处理，删除节点无子节点直接删除
            if(node.left == null && node.right == null){

            }
            //只有一个子节点，直接移动到被删除元素的位置

            //有多个子节点，在左子树里找到最大的元素放到被删除元素的位置


            return null;
        }
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


    public static void main(String[] args) {
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

    }
}

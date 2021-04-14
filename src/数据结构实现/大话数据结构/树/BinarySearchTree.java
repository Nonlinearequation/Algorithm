package 数据结构实现.大话数据结构.树;

import java.util.Objects;

/**
 * 二叉查找树-思路来自五分钟学算法
 */
public class BinarySearchTree<E extends Comparable<E>> {

    public class Node {
        private E e;//节点元素值
        private Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }

        public E getE() {
            return e;
        }

        public void setE(E e) {
            this.e = e;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    private Node root;//根节点
    private int size;//树中元素的个数

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

//    public void add(E e){
//        root = add(root,e);//为了添加根元素不出错
//    }
//
//    /**
//     * 添加元素，递归查找添加元素的位置。左子树的节点都比根节点小，右子树的节点都比根节点大
//     * @param node
//     * @param e 实现comparable接口的
//     * @return
//     */
//    private Node add(Node node, E e) {
//        if(node == null){//如果node为空，意味着已经找到了可以插入的节点
//            size++;
//            return new Node(e);
//        }
//        if(e.compareTo(node.e)<0){//如果插入节点小于当前节点，向当前节点的左子树添加节点
//            node.left = add(node.left,e);//递归调用add方法，查找左子树，直到节点的子节点为空，返回node。此时退出本层递归，返回的node就是父节点的左/右子节点
//        }else{
//            node.right = add(node.right,e);//如果插入节点大于当前节点，向当前节点的右子树添加节点
//        }
//        return node;
//    }
//
//    /**
//     * 删除节点，在左子树中找到最大的子节点，移到被删除的位置上
//     */
//    private void remove(E e){
//        root = remove(root,e);//为了删除根元素
//    }
//
//    /**
//     * 删除元素，递归查找删除元素的位置。如果删除元素小于当前节点，查找左子树；如果大于当前节点，查找右子树。
//     * 删除时，1 如果被删除节点的后代为空，直接删除；2 如果只有一个后代，移动到被删除元素的位置；
//     * 3 有多个后代，在左子树中找到最大的子节点，或在右子树找到最小的子节点，移动到被删除元素的位置。
//     * 如果最终未找到元素，返回最接近的节点。
//     * @param node
//     * @param e
//     * @return
//     */
//    private Node remove(Node node, E e) {
//        if(node == null){
//            return null;
//        }
//        if(e.compareTo(node.e)<0){//元素e小于当前节点，查找左子树
//            node.left = remove(node.left,e);//递归查找左子树，如果子节点返回null，则赋值左节点为null（删除）
//            return node;
//        }else if(e.compareTo(node.e)>0){//元素e大于当前节点，查找右子树
//            node.right = remove(node.right,e);
//            return node;
//        }else{//相等，删除元素
//            //分情况处理，删除节点无子节点直接删除
//            if(node.left == null && node.right == null){
//                node = null;
//                return null;
//            }else if(node.left == null){//只有一个子节点，直接移动到被删除元素的位置
//                Node temp = node.right;
//                node.right = null;
//                node = null;
//                return temp;
//            }else if(node.right == null){
//                Node temp = node.left;
//                node.left = null;
//                node = null;
//                return temp;
//            }else{//有多个子节点，在左子树里找到最大的元素放到被删除元素的位置
//                Node temp = maxNode(node.left);//在左子树里找最大的
//                temp.right = node.right;
//                temp.left = removeMaxNode(node.left);
//                return temp;
//            }
//        }
//    }
//
//    /**
//     * 移除最大子节点，找到最大子节点并删除，然后将它返回出去。如果最大子节点有左子树，令左子树占最大字节的位置。
//     * @param left
//     * @return
//     */
//    private Node removeMaxNode(Node left) {
//        Node maxNode = maxNode(left);
//
//
//        return null;
//    }
//
//    /**
//     * 找最大的节点，那就是找最底层最右边的子节点
//     * @param left
//     * @return
//     */
//    private Node maxNode(Node left) {
//        Node node = left;
//        while(node.right!=null){
//            node = node.right;
//        }
//        return node;
//    }


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

    /**
     * 避免重复的插入二叉树
     * @param e
     * @return
     */
    public Node insert(E e){
        if(root==null){
            root = new Node(e);
            return root;
        }
        Node x = binSearch(root,e);//查找返回待插入的节点
        if (e.compareTo(x.e)!=0) {//避免重复
            Node newNode = new Node(e);
            if(e.compareTo(x.e)<0){
                x.left = newNode;
            }else if(e.compareTo(x.e)>0){
                x.right = newNode;
            }
            size++;
            //updateHightAbove(x);//更新全树规模，x以及历代祖先高度
        }
        return x;
    }

    /**
     * 允许重复的二分查找树，初始node传参应为root。
     * 二分查找树中如果存在多个e，则深度最小的e必然唯一
     * @param node
     * @param e
     * @return
     */
    public Node insertRepeat(Node node,E e){
        if(root==null){
            root = new Node(e);
            return root;
        }
        Node x = binSearch(node,e);//查找返回待插入的节点，(允许重复的情况下)返回的是深度最小的节点
        if (e.compareTo(x.e)!=0) {//不重复
            Node newNode = new Node(e);
            if(e.compareTo(x.e)<0){
                x.left = newNode;
            }else{
                x.right = newNode;
            }
            size++;
            //updateHightAbove(x);//更新全树规模，x以及历代祖先高度
        }else{//找到与e相同的元素，如果左/右子树为空，直接插入；如果不为空，继续再下一层查找e，看能否插入
            if(x.left==null){//左子树为空
                Node newNode = new Node(e);
                x.left = newNode;
                return newNode;
            }else if(x.right==null){//右子树为空
                Node newNode = new Node(e);
                x.right = newNode;
                return newNode;
            }else{//左右都为不为空，查找下一层
                Node newNode = insertRepeat(x.left,e);
                return newNode;
            }
        }
        return x;
    }

    /**
     * 迭代删除节点
     * @param e
     * @return
     */
    private void removeByIterative(E e){
        Node parent = null;//记录被删除元素的双亲节点
        Node temp = this.root;//被删除节点
        int rightOrLeft = -1;//0：左 1：右
        //迭代找到要被删除元素的双亲节点和自身节点，如果没找到，temp = null,parent是最后遍历的节点
        while(temp != null){
            if(e.compareTo(temp.e)==0){
                break;
            }else if(e.compareTo(temp.e)<0){
                parent = temp;
                temp = parent.left;
                rightOrLeft = 0;
            }else{
                parent = temp;
                temp = parent.right;
                rightOrLeft = 1;
            }
        }

        //删除
        if(temp != null ){
            Node replacement;
            if(temp.left == null){
                replacement = temp.right;
                temp.right = null;
            }else if(temp.right == null){
                replacement = temp.left;
                temp.left = null;
            }else{//左右都不为空
                if(temp.right.left == null){//被删除节点w的后继v是它的右子节点（右子节点没有左子树）
                    //将v的值复制给w
                    temp.e = temp.right.e;
                    replacement = temp;
                    //用v的右子树替代v的位置（v的左子树为空）
                    temp.right = temp.right.right;
                }else{//如果w的右子节点的左右子节点都不为空
                    //迭代拿到w的后继和它的双亲节点
                    Node parent2 = temp.right;
                    Node child = temp.right.left;
                    while(child.left!=null){
                        parent2 = child;
                        child = parent2.left;
                    }
                    //将v的值赋值给w，并用v的右子树替代v的位置（v的左子树为空）
                    temp.e = child.e;
                    parent2.left = child.right;
                    replacement = temp;
                }
            }
            if(parent == null){//如果删除的是根节点，修改指向
                //root->替换删除元素后的节点
                this.root = replacement;
            }else{//如果不是根节点
                //如果被删除元素在parent的左节点上，替换左节点
                if(rightOrLeft == 0){
                    parent.left = replacement;
                }else{//相应的，如果被删除元素在parent的右节点上，替换右节点
                    parent.right = replacement;
                }
            }
        }
    }

    private void removeByRecursive(E e){
        this.root = removeByRecursive(this.root,e);
    }

    /**
     * 删除节点（递归）
     * 分两种情况，一是左/右子树为空（或都为空），删除元素v并将右/左节点移动到被删除的元素位置；
     * 二是左右子树都不为空，查找它的前驱w，并交换w和元素v。摘除v，并代之以它的左孩子
     * @param node
     * @param e
     * @return
     */
    private Node removeByRecursive(Node node,E e){
        if(node == null){
            return null;
        }
        if(e.compareTo(node.e)<0){
            node.left = removeByRecursive(node.left,e);
        }else if(e.compareTo(node.e)>0){
            node.right = removeByRecursive(node.right,e);
        }else {
            //左子树为空，直接用右子树替换被删除节点
            if (node.left == null) {
                Node temp = node.right;
                node.right = null;
                node = temp;
            } else if (node.right == null) {//相应的，右子树为空，直接用左子树替换被删除节点
                Node temp = node.left;
                node.left = null;
                node = temp;
            } else {//左右都不为空，用前驱的值与当前元素的值交换，并在前驱节点的迭代删除当前元素
                Node temp = node.left;
                //拿到该节点的前驱
                while (temp.right != null) {
                    temp = temp.right;
                }
                //将前驱的值赋值给node
                node.e = temp.e;
                //删除节点(交换位置后)，前驱元素的右子树必为空
                node.left = removeByRecursive(node.left,temp.e);
            }
        }
        return node;
    }


    public static void main(String[] args) {
        /** 不重复的树
         *               15
         *            /     \
         *           9      23
         *         /   \    /  \
         *        3    12  17  28
         *      /  \
         *     1   4
         *           \
         *            8
         */
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(15);
        bst.insert(9);
        bst.insert(23);
        bst.insert(3);
        bst.insert(12);
        bst.insert(1);
        bst.insert(4);
        bst.insert(8);
        bst.insert(17);
        bst.insert(28);
        System.out.print("中序遍历：");
        bst.inOrderTraverse(bst.root);
        System.out.println("\n查找元素（递归）：" + bst.binSearch(bst.root,55).e);
        System.out.println("查找元素（迭代）：" + bst.binSearchByLoop(bst.root,4).e);


        /** 重复的树
         *                   36
         *                /      \
         *              27       58
         *           /          /   \
         *          6          58   94
         *                  /    \
         *                 46    58
         *                  \
         *                  50
         *                   \
         *                   58
         */
        BinarySearchTree<Integer> bstRepeat = new BinarySearchTree<>();
        bstRepeat.insertRepeat(bstRepeat.root,36);
        bstRepeat.insertRepeat(bstRepeat.root,27);
        bstRepeat.insertRepeat(bstRepeat.root,6);
        bstRepeat.insertRepeat(bstRepeat.root,58);
        bstRepeat.insertRepeat(bstRepeat.root,94);
        bstRepeat.insertRepeat(bstRepeat.root,58);
        bstRepeat.insertRepeat(bstRepeat.root,46);
        bstRepeat.insertRepeat(bstRepeat.root,58);
        bstRepeat.insertRepeat(bstRepeat.root,50);
        bstRepeat.insertRepeat(bstRepeat.root,58);
        System.out.println("可重复的二分查找树\n查找元素(递归):"+bstRepeat.binSearch(bstRepeat.root, 58).e+
                "，左子树："+bstRepeat.binSearch(bstRepeat.root, 58).left.e
                +"，右子树："+bstRepeat.binSearch(bstRepeat.root, 58).right.e);
        bstRepeat.removeByRecursive(58);
        /** 删除58后的树
         *                   36
         *                /      \
         *              27       58
         *           /          /   \
         *          6          58   94
         *                  /    \
         *                 46    58
         *                  \
         *                  50
         */
        bstRepeat.removeByRecursive(58);
        /** 删除第二个58后的树
         *                   36
         *                /      \
         *              27        58
         *           /          /   \
         *          6         50     94
         *                   /  \
         *                  46  58
         */
        bstRepeat.removeByRecursive(58);
        /** 删除第三个58后的树
         *                   36
         *                /      \
         *              27        58
         *           /          /   \
         *          6         50     94
         *                   /
         *                  46
         */
        System.out.println("左："+bstRepeat.binSearch(bstRepeat.root, 58).left.e);//50
        System.out.println("右："+bstRepeat.binSearch(bstRepeat.root, 58).right.e);//94
        bstRepeat.removeByIterative(58);
        /** 删除第四个58后的树（后继替代）
         *                   36
         *                /      \
         *              27        58
         *           /          /   \
         *          6         50     94
         *                   /
         *                  46
         */
        System.out.println("右："+bstRepeat.binSearch(bstRepeat.root, 94).left.e);//50
        System.out.println("右："+bstRepeat.binSearch(bstRepeat.root, 94).right);//null
    }
}

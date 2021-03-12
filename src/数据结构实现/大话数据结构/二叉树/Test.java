package 数据结构实现.大话数据结构.二叉树;

public class Test {

    public static void main(String[] args) {

        BiNode<String> k = new BiNode<>("k");
        BiNode<String> j = new BiNode<>("j");
        BiNode<String> i = new BiNode<>("i");
        BiNode<String> h = new BiNode<>("h",null,k);
        BiNode<String> g = new BiNode<>("g",null,j);
        BiNode<String> f = new BiNode<>("f",i,null);
        BiNode<String> e = new BiNode<>("e");
        BiNode<String> d = new BiNode<>("d",h,null);
        BiNode<String> b = new BiNode<>("b",d,e);
        BiNode<String> c = new BiNode<>("c",f,g);
        BiNode<String> a = new BiNode<>("a",b,c);

        BiTree tree = new BiTree();
        System.out.println("先序遍历");
        tree.preOrderTraverse(a);

        System.out.println("\n中序遍历");
        tree.inOrderTraverse(a);

        System.out.println("\n后序遍历");
        tree.postOrderTraverse(a);


        /*线索二叉树
         *           a
         *         /   \
         *        b     c
         *       / \   / \
         *      d  e  f  g
         *     / \ \
         *    h  i  j
         * */
        ThreadedBinaryTree a1=null,b1=null,c1=null,d1=null,e1=null,f1=null,g1=null,h1=null,i1=null,j1=null;
        h1 = new ThreadedBinaryTree("h",null,false,null,false);
        i1 = new ThreadedBinaryTree("i",null,false,null,false);
        j1 = new ThreadedBinaryTree("j",null,false,null,false);
        f1 = new ThreadedBinaryTree("f",null,false,null,false);
        g1 = new ThreadedBinaryTree("g",null,false,null,false);
        d1 = new ThreadedBinaryTree("d",h1,false,i1,false);
        e1 = new ThreadedBinaryTree("e",null,false,j1,false);
        b1 = new ThreadedBinaryTree("b",d1,false,e1,false);
        c1 = new ThreadedBinaryTree("c",f1,false,g1,false);
        a1 = new ThreadedBinaryTree("a",b1,false,c1,false);
        a1.inThreading(a1);//线索二叉树的中序线索化
        System.out.print("\n线索二叉树中序遍历（不递归）：");
        a1.inOrderTraverse(a1);
    }

}

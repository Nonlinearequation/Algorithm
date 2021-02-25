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
    }

}

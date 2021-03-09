package 数据结构实现.大话数据结构.树;

import 数据结构实现.大话数据结构.二叉树.ThreadedBinaryTree;

import javax.swing.*;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        Tree<String> tree = new Tree<>();
        tree.initTree();
        //根节点
        tree.insertChild("a",-1);
        tree.insertChild("b",0);
        tree.insertChild("c",0);
        tree.insertChild("d",1);
        tree.insertChild("e",2);
        tree.insertChild("f",3);
        tree.insertChild("g",3);
        /**
         * 上述树表现为：
         *          a
         *         / \
         *        b   c
         *       /   /
         *      d    e
         *     / \
         *    f  g
         */
        //获取双亲节点
        System.out.println(tree.parent(new Node("g", 3)).data);


        Tree2 tree2 = new Tree2();
        tree2.initTree();
        tree2.insertChild("a",-1);
        tree2.insertChild("b",0);
        tree2.insertChild("c",0);
        tree2.insertChild("d",1);
        tree2.insertChild("e",1);
        tree2.insertChild("f",1);
        tree2.insertChild("g",2);
        tree2.insertChild("h",3);
        tree2.insertChild("i",4);
        tree2.insertChild("j",5);
        tree2.insertChild("k",5);
        /**
         *           a
         *        /     \
         *       b       c
         *    /  |  \     \
         *   d   e  f      g
         *   |   |  | \
         *   h   i  j  k
         */
        System.out.println(tree2.parent(new BoxNode("c")).getData());

        TreeLinkedList a=null,b=null,c=null,d=null,e=null,f=null,g=null,h=null,i=null,j=null,k=null;
        k = new TreeLinkedList("k",f,null,null);
        j = new TreeLinkedList("j",f,null,k);
        i = new TreeLinkedList("i",e,null,null);
        h = new TreeLinkedList("h",d,null,null);
        g = new TreeLinkedList("g",c,null,null);
        f = new TreeLinkedList("f",b,j,null);
        e = new TreeLinkedList("e",b,i,f);
        d = new TreeLinkedList("d",b,h,e);
        c = new TreeLinkedList("c",a,g,null);
        b = new TreeLinkedList("b",a,d,c);
        a = new TreeLinkedList("a",null,b,null);
        System.out.print("\n一般树的遍历:\n前序遍历：");
        a.preOrderTraversal(a);
        System.out.print("\n后序遍历：");
        a.postorderIterator(a);
        System.out.println();


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
        a1.inThreading(a1);
        System.out.println("线索二叉树中序遍历（不递归）：");
        a1.inOrderTraverse(a1);
        System.out.println();




    }

}

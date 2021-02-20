package 数据结构实现.大话数据结构.树;

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


    }

}

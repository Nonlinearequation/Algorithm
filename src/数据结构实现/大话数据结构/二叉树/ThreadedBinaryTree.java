package 数据结构实现.大话数据结构.二叉树;

import java.util.Objects;

/**
 * 线索二叉树
 * 知道从当前位置到下一步应该走向哪里
 * 指向前驱和后继的指针称为线索，加上线索的二叉树成为线索链表，相应的二叉树就称为线索二叉树
 * 线索化的实质就是将二叉链表中的空指针改为前驱或后继的线索。
 * 由于前驱和后继的信息只有遍历二叉树时才能得到，所以线索化的过程就是在遍历的过程中修改空指针的过程。
 *
 * @author xi553
 */
public class ThreadedBinaryTree {

    /*数据*/
    private Object data;

    private ThreadedBinaryTree left;//左子树

    //左子树是否为线索
    private boolean leftIsThread;

    private ThreadedBinaryTree right;//右子树

    //左子树是否为线索
    private boolean rightIsThread;

    /*全局变量，指向刚刚访问过的节点*/
    private ThreadedBinaryTree pre;

    public ThreadedBinaryTree(Object data, ThreadedBinaryTree left, boolean leftIsThread, ThreadedBinaryTree right, boolean rightIsThread) {
        this.data = data;
        this.left = left;
        this.leftIsThread = leftIsThread;
        this.right = right;
        this.rightIsThread = rightIsThread;
    }

    /**
     * 线索化：根据中序遍历的顺序，将左空指针指向前驱、右空指针指向后继
     * 先递归找左子树，左子树为空则找到了中序遍历的开始节点。
     * <p>
     * 递归算法：
     * inthread(v){
     * if(v==null)
     * return;
     * 查找左子树inthread
     * if(左子树为空)
     * v的左节点指向前驱（第一个中序遍历的节点没有前驱，left->pre(null)）
     * if(遍历的上一个节点的右子树为空)
     * 上一个节点的后继指向当前节点v
     * 上一个节点 = 当前节点
     * 查找右子树inthread
     * }
     *
     * @param tree
     */
    public void inThreading(ThreadedBinaryTree tree) {
        if (tree == null) {
            return;
        }
        inThreading(tree.getLeft());//中序遍历，先进入左子树
        if (tree.getLeft() == null) {//左子树为null
            tree.setLeftIsThread(true);//令左子树为上一个节点pre
            tree.setLeft(pre);
        }
        if (pre != null && pre.getRight() == null) {//上一个子节点不为null且右节点为空
            pre.setRightIsThread(true);//令上一个节点的右子树为当前节点
            pre.setRight(tree);
        }
        pre = tree;
        inThreading(tree.getRight());
    }

    /**
     * 中序遍历树，线索二叉树的优点在于可以像链表一样直接迭代所有节点，而无需递归（节省了空间），
     * 取出任意节点的前驱和后继也无需遍历整个二叉树（节省了时间）
     *
     * ①先找到最左的节点
     * ②如果此节点有后继，就循环一直取出。如果有右子树，就将它作为新的循环节点，重复第一步。
     * @param tree
     */
    public void inOrderTraverse(ThreadedBinaryTree tree) {
        if (tree == null) {
            return;
        }
        ThreadedBinaryTree p = tree;
        while (p != null) {
            while (p != null && !p.isLeftIsThread()) {//找到最左边的子树
                p = p.getLeft();
            }

            System.out.print(p.getData());
            while (p != null && p.isRightIsThread()) {
                //找后继，如果有就打印。直到获取到右节点，赋值给临时变量，继续循环找左，再找后继，再找右子树，以此类推。
                p = p.getRight();
                System.out.print(p.getData());
            }
            p = p.getRight();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        ThreadedBinaryTree objTree = (ThreadedBinaryTree) o;
        if (objTree.getData().equals(this.getData())) {
            return true;
        }
        return false;

    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ThreadedBinaryTree getLeft() {
        return left;
    }

    public void setLeft(ThreadedBinaryTree left) {
        this.left = left;
    }

    public boolean isLeftIsThread() {
        return leftIsThread;
    }

    public void setLeftIsThread(boolean leftIsThread) {
        this.leftIsThread = leftIsThread;
    }

    public ThreadedBinaryTree getRight() {
        return right;
    }

    public void setRight(ThreadedBinaryTree right) {
        this.right = right;
    }

    public boolean isRightIsThread() {
        return rightIsThread;
    }

    public void setRightIsThread(boolean rightIsThread) {
        this.rightIsThread = rightIsThread;
    }

    public ThreadedBinaryTree getPre() {
        return pre;
    }

    public void setPre(ThreadedBinaryTree pre) {
        this.pre = pre;
    }
}

package 数据结构实现.大话数据结构.二叉树;


/**
 * 二叉树，完全二叉树可以用顺序结构存储。如果不是，可以用链表存储
 * @author xi553
 */
public class BiTree {

    private BiNode root;

    /**
     * 疑问：只有根据先序+中序 or 后序+中序 才能确定一棵树，那么如何通过先序遍历的字符串生成树呢？不能吧。
     * 书 6.9最后的构建二叉树算法，我觉得有问题。
     * 网上有相关的实现。比根节点大的节点在左子树，比根节点小的在右子树。
     * --更新：书中没有提到节点数据大小与数据的关系，在网上查阅资料发现，一般都是二叉搜索树
     * @param data
     * @return
     */
    public BiNode preOrderCreate(int data){
        BiNode parent = null;

        return root;
    }



    /**
     * 先序遍历（递归算法）
     * @param t
     */
    public void preOrderTraverse(BiNode t){
        if(t == null){
            return;
        }
        System.out.print(t.getData());
        preOrderTraverse(t.getLeftChild());
        preOrderTraverse(t.getRightNode());
    }

    /**
     * 中序遍历（递归算法）
     * @param t
     */
    public void inOrderTraverse(BiNode t){
        if(t == null){
            return;
        }
        inOrderTraverse(t.getLeftChild());
        System.out.print(t.getData());
        inOrderTraverse(t.getRightNode());
    }

    public void postOrderTraverse(BiNode t){
        if(t == null){
            return;
        }
        postOrderTraverse(t.getLeftChild());
        postOrderTraverse(t.getRightNode());
        System.out.print(t.getData());
    }



}

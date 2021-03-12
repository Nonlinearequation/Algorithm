package 面试题练习;

public class LeetCode二叉树的深度 {
    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public static void main(String[] args) {

        /**
         *          a
         *         /  \
         *        b    c
         *      /  \   /
         *     d   e  f
         */
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        a.left=b;a.right=c;
        b.left=d;b.right=e;
        c.left=f;
        System.out.println(maxDepth(a));


    }

    /***
     * 递归算法计算深度
   * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        int depth = -1;
        if(root!=null){
            depth = Math.max(depth,maxDepth(root.left));
            depth = Math.max(depth,maxDepth(root.right));
        }
        return depth+1;
    }

    /**
     * 层次遍历算法
     * @param root
     * @return
     */
    public static int maxDepth2(TreeNode root){
        int depth = -1;
        return depth+1;
    }
}

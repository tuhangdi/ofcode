package leetcode.Tree;

/**
 * Created by thd on 2017/8/21
 *
 * Given a binary tree, find the maximum path sum.
 给定一个二叉树，找到最大路径和。
 For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

 For example:
 Given the below binary tree,

 1
 / \
 2   3
 Return 6.

 */
public class n124BinaryTreeMaximumPathSum {
    int maxValue;
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);//此时node为根结点的路径和
        return Math.max(left, right) + node.val; //返回node和较大的子结点的和作为node父结点的子树
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2;
        t1.right = t5;
        t2.left = t3;
        t2.right = t4;
        t5.right = t6;
        n124BinaryTreeMaximumPathSum n = new n124BinaryTreeMaximumPathSum();
        System.out.println(n.maxPathSum(t1));


    }
}

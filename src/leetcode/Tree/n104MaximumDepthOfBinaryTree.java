package leetcode.Tree;

/**
 * Created by thd on 2017/6/29.
 * Given a binary tree, find its maximum depth.
 给定二叉树，找到最大深度。
 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.


 */
public class n104MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int depl = maxDepth(root.left);
        int depr = maxDepth(root.right);
        return depl > depr ? depl + 1 : depr + 1;
    }
}

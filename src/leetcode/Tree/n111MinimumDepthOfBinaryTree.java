package leetcode.Tree;

/**
 * Created by thd on 2017/6/29.
 * Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.


 和找最大距离不同之处在于：可能存在左或右子树为空的情况，此时值就为0，但显然值是不为0的（只有当二叉树为空才为0）
 */
public class n111MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int depl = minDepth(root.left);
        int depr = minDepth(root.right);
        if (depl == 0 || depr == 0) return depl + depr + 1;
        return depl < depr ? depl + 1 : depr + 1;
    }
}

package leetcode.DFS;

/**
 * Created by thd on 2017/8/18
 * 给定二叉树，确定它是否是有效的二叉搜索树（BST）。

 */
public class n98ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return inorder(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean inorder (TreeNode node, long minValue, long maxValue) {
        if (node == null) return true;
        if (node.val >= maxValue || node.val <= minValue) return false;
        return inorder(node.left, minValue, node.val) && inorder(node.right, node.val, maxValue);
    }
}

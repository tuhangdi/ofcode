package leetcode.Tree;

/**
 * Created by thd on 2017/9/4
 *
 Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 给定一个二叉树，您需要计算树的直径的长度。 二叉树的直径是树中任意两个节点之间最长路径的长度。 此路径可能通过或可能不通过根。
 Example:
 Given a binary tree
 1
 / \
 2   3
 / \
 4   5
 Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

 Note: The length of path between two nodes is represented by the number of edges between them.

 对于每个节点，通过它的最长路径的长度=其左子树的MaxDepth +其右子树的MaxDepth。
 */
public class n543DiameterOfBinaryTree {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
}

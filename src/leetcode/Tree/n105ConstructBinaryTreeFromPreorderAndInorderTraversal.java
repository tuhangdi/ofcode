package leetcode.Tree;

/**
 * Created by thd on 2017/8/21
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 给定树的顺序和顺序遍历，构造二叉树。
 Note:
 You may assume that duplicates do not exist in the tree.
 */
public class n105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int intIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val)
                    intIndex = i;
        }
        root.left = helper(preStart + 1, inStart, intIndex - 1, preorder, inorder);
        root.right = helper(preStart + intIndex - inStart + 1, intIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}

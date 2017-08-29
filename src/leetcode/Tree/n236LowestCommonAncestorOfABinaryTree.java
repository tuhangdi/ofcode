package leetcode.Tree;

/**
 * Created by thd on 2017/8/29
 *
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 给定二叉树，找到树中两个给定节点的最低共同祖先（LCA）。
 According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

 _______3______
 /              \
 ___5__          ___1__
 /      \        /      \
 6      _2       0       8
 /  \
 7   4
 For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 例如，节点5和1的最低共同祖先（LCA）为3.另一个例子是节点5和节点4的LCA是5，因为根据LCA定义，节点可以是其自身的后代。

 */

public class n236LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }
}

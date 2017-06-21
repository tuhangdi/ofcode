package leetcode.Tree;

import sun.reflect.generics.tree.Tree;

/**
 * Created by thd on 2017/6/21.
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * 给定两个二叉树，并且想象当你把其中一个覆盖另一个时，两个树的一些节点是重叠的，而另外一些没有。
 You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 您需要将它们合并到一个新的二叉树中。 合并规则是如果两个节点重叠，则sum节点值作为合并节点的新值。 否则，NOT空节点将被用作新树的节点。

 Example 1:
 Input:
 Tree 1                     Tree 2
 1                         2
 / \                       / \
 3   2                     1   3
 /                           \   \
 5                             4   7
 Output:
 Merged tree:
 3
 / \
 4   5
 / \   \
 5   4   7
 *
 *
 *
 *
 如果t1和t2中至少一个为NULL，则返回指向(t1, t2)中的非NULL节点；
 如果t1和t2都不为NULL，则继续递归建立链接关系
 */
public class n617MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        TreeNode root = new TreeNode((t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val));
        root.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        root.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);

        return root;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(5);

        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(4);
        TreeNode node9 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;

        node5.left = node6;
        node5.right = node7;
        node6.right = node8;
        node7.right = node9;

        n617MergeTwoBinaryTrees n = new n617MergeTwoBinaryTrees();
        n.mergeTrees(node1, node5);

    }
}

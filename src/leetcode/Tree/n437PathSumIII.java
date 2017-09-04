package leetcode.Tree;

import sun.reflect.generics.tree.Tree;

/**
 * Created by thd on 2017/9/4
 * You are given a binary tree in which each node contains an integer value.
 给定一个二叉树，其中每个节点包含一个整数值。
 Find the number of paths that sum to a given value.
 找到与给定值相加的路径数。
 The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 该路径不需要在根节点或叶子上开始或结束，但是它必须向下移动（仅从父节点移动到子节点）。
 The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

 Example:

 root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

 10
 /  \
 5   -3
 / \    \
 3   2   11
 / \   \
 3  -2   1

The paths that sum to 8 are:

 1.  5 -> 3
 2.  5 -> 2 -> 1
 3. -3 -> 11


 递归DFS！！
 */
public class n437PathSumIII {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }
}

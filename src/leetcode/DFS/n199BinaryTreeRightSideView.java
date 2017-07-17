package leetcode.DFS;


import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thd on 2017/7/17.
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 给定一个二叉树，想象你自己站在它的右侧，返回从顶部到底部可以看到的节点的值。
 For example:
 Given the following binary tree,
 1            <---
 /   \
 2     3         <---
 \     \
 5     4       <---
 You should return [1, 3, 4].
 */
public class n199BinaryTreeRightSideView {
    int f = 0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        res = dfs(root, res, 0);
        return res;
    }
    private List<Integer> dfs(TreeNode root, List<Integer> res, int floor) {
        if (root == null) return res;
        if (floor == f) {
            res.add(root.val);
            f++;
        }

        dfs(root.right, res, floor+1);
        dfs(root.left, res, floor+1);
        return res;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        n199BinaryTreeRightSideView n = new n199BinaryTreeRightSideView();
        System.out.println(n.rightSideView(t1).toString());
    }
}

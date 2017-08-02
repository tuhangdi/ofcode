package leetcode.BFS;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by thd on 2017/8/2
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

 1
 / \
 2   2
 / \ / \
 3  4 4  3
 But the following [1,2,2,null,3,null,3] is not:
 1
 / \
 2   2
 \   \
 3    3

 */
public class n101SymmetricTree {
    public boolean isSymmetricBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return true;
        queue.add(root.left);
        queue.add(root.right);
        while (queue.size() > 1) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    public boolean isSymmetricDFS(TreeNode root) {
        return root == null || dfs(root.left, root.right);
    }
    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}

package leetcode.BFS;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by thd on 2017/8/2
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
 ]
 */
public class n102BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        queue.add(root);
        int queueSize = root == null ? 0 : 1;
        while (queueSize > 0){
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < queueSize; i++) {
                if (queue.peek().left != null) queue.add(queue.peek().left);
                if (queue.peek().right != null) queue.add(queue.peek().right);
                list.add(queue.poll().val);
            }
            res.add(list);
            queueSize = queue.size();
        }
        return res;
    }

    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        dfs(root, res, 0);
        return res;
    }
    private void dfs(TreeNode root, LinkedList<List<Integer>> res, int d) {
        if (root == null) return;
        if (d >= res.size())
            res.add(new LinkedList<>());
        dfs(root.left, res, d + 1);
        dfs(root.right, res, d + 1);
        res.get(d).add(root.val);
    }
}

package leetcode.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by thd on 2017/8/2
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
 */
public class n107BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottomBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);
        int queuesize = root == null ? 0 : 1;
        while (queuesize > 0) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < queuesize; i++) {
                if (queue.peek().left != null) queue.add(queue.peek().left);
                if (queue.peek().right != null) queue.add(queue.peek().right);
                list.add(queue.poll().val);
            }
            res.add(0, list);
            queuesize = queue.size();
        }
        return res;
    }

    public List<List<Integer>> levelOrderBottomDFS(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        dfs(root, res, 0);
        return res;
    }
    private void dfs(TreeNode root, LinkedList<List<Integer>> res, int d) {
        if (root == null) return;
        if (d >= res.size())
            res.add(0, new LinkedList<>());
        dfs(root.left, res, d + 1);
        dfs(root.right, res, d + 1);
        res.get(res.size() - d - 1).add(root.val);
    }
}

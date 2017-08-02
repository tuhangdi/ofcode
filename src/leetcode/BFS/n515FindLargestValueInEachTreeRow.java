package leetcode.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by thd on 2017/8/2
 * <p>
 * You need to find the largest value in each row of a binary tree.
 * <p>
 * Example:
 * Input:
 * <p>
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 * <p>
 * Output: [1, 3, 9]
 */
public class n515FindLargestValueInEachTreeRow {
    public List<Integer> largestValuesBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<>();
        queue.add(root);
        int queueSize = root == null ? 0 : 1;
        while (queueSize > 0) {
            int largerstElement = Integer.MIN_VALUE;
            for (int i = 0; i < queueSize; i++) {
                TreeNode cur = queue.poll();
                largerstElement = Math.max(cur.val, largerstElement);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            res.add(largerstElement);
            queueSize = queue.size();
        }
        return res;
    }

    public List<Integer> largestValuesDFS(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res, int d) {
        if (root == null) return;
        if (d == res.size()) {
            res.add(root.val);
        } else {
            res.set(d, Math.max(res.get(d), root.val));//将d位置值替换成Math.max(res.get(d), root.val)，并返回原值
        }
        dfs(root.left, res, d + 1);
        dfs(root.right, res, d + 1);

    }

}

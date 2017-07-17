package leetcode.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thd on 2017/7/17.
 * Given a binary tree, return all root-to-leaf paths.
 给定一个二叉树，返回所有根到叶的路径。
 For example, given the following binary tree:

 1
 /   \
 2     3
 \
 5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]
 */
public class n257BinaryTreePaths {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, new StringBuilder());
        return res;
    }
    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null)
            res.add(sb.toString());
        else {
            sb.append("->");
            dfs(root.left, sb);
            dfs(root.right, sb);
        }
        sb.setLength(len);
    }
}

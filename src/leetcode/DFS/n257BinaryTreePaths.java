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
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        n257BinaryTreePaths n = new n257BinaryTreePaths();
        System.out.println(n.binaryTreePaths(t1).toString());
    }
}

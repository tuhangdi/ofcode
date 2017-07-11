package leetcode.DFS;

/**
 * Created by thd on 2017/7/11.
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * 给定一个二叉树，找到树的最后一行的最左边的值。
 * Example 1:
 Input:

 2
 / \
 1   3

 Output:
 1

 Example 2:
 Input:

 1
 / \
 2   3
 /   / \
 4   5   6
    /
   7

 Output:
 7
 */
public class n513FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;
        dfs(root, 0);
        return res;
    }
    int res = 0;
    int depall = 0;
    private void dfs(TreeNode root, int dep) {
        if (root == null) return;
        if (depall < dep) {
            res = root.val;
            depall = dep;
        }
        dfs(root.left, dep + 1);
        dfs(root.right, dep + 1);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        n513FindBottomLeftTreeValue n = new n513FindBottomLeftTreeValue();
        System.out.println(n.findBottomLeftValue(n1));
    }
}

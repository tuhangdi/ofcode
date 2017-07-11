package leetcode.DFS;

/**
 * Created by thd on 2017/7/11.
 * Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class n100SameTree {
    //boolean isEqual = false;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }
    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val){
            return dfs(p.left, q.left) && dfs(p.right, q.right);
        }
        return false;

    }
}

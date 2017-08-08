package jianzhioffer;

/**
 * Created by thd on 2017/3/3.
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class mirrortree {
    public void Mirror(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        TreeNode tempnode = root.left;
        root.left = root.right;
        root.right = tempnode;
        if(root.left != null) Mirror(root.left);
        if(root.right != null) Mirror(root.right);
    }
}

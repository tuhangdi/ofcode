/**
 * Created by thd on 2017/3/16.
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树.
 * 如果某二叉树任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class Treedep39_2 {
    //用后序遍历，在遍历到一个结点之前就已经遍历了它的左右子树。
    //只需在遍历每个结点时记录它的深度。
    private boolean isBalanced = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }
    public int getDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);

        if(Math.abs(left - right) > 1)
            isBalanced = false;
        return right > left ? (right + 1) : (left + 1);
    }

}

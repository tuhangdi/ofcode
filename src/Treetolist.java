/**
 * Created by thd on 2017/3/6.
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Treetolist {
    TreeNode lefthead = null;
    TreeNode righthead = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        Convert(pRootOfTree.left);
        if(righthead == null)
            lefthead = righthead = pRootOfTree;
        else{
            righthead.right = pRootOfTree;
            pRootOfTree.left = righthead;
            righthead = pRootOfTree;
        }
        Convert(pRootOfTree.right);
        return lefthead;
    }
}

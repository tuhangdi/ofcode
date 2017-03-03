import sun.reflect.generics.tree.Tree;

import java.util.HashMap;

/**
 * Created by thd on 2017/3/3.
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */

public class Subtree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1 != null && root2 != null){
            if(root1.val == root2.val)
                result = Judge(root1, root2);
            if(!result)
                result = HasSubtree(root1.left, root2);
            if(!result)
                result = HasSubtree(root1.right, root2);
        }
        return result;
    }
    public boolean Judge(TreeNode root1, TreeNode root2){
        if(root2 == null) return true;
        if (root1 == null && root2 != null) return false;
        if(root1.val == root2.val)
            return Judge(root1.left, root2.left) && Judge(root1.right, root2.right);
        else
            return false;
    }
    public static void main(String[] args){
        TreeNode tree1 = new TreeNode(8);
        TreeNode tree2 = new TreeNode(8);
        TreeNode treenode1 = new TreeNode(9);
        TreeNode treenode2 = new TreeNode(2);
        tree2.left = treenode1;
        tree2.right = treenode2;
        TreeNode treenode3 = new TreeNode(7);
        TreeNode treenode4 = new TreeNode(4);
        TreeNode treenode5 = new TreeNode(8);
        TreeNode treenode6 = new TreeNode(9);
        TreeNode treenode7 = new TreeNode(2);
        TreeNode treenode8 = new TreeNode(7);
        tree1.left = treenode5;
        tree1.right = treenode3;
        treenode5.left = treenode6;
        treenode5.right = treenode7;
        treenode7.left = treenode4;
        treenode7.right = treenode8;

        Subtree st = new Subtree();
        boolean result = st.HasSubtree(tree1, tree2);
        if(result) System.out.println("true");


    }
}

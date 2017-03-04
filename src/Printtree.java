import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;


/**
 * Created by thd on 2017/3/4.
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Printtree {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if(root == null) return list;
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode t = queue.pop();
            list.add(t.val);
            System.out.println(t.val);
            if(t.left != null) queue.add(t.left);
            if(t.right != null) queue.add(t.right);
        }
        return list;
    }
    public static void main(String[] args){
        Printtree pt = new Printtree();
        TreeNode tree1 = new TreeNode(8);
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
        pt.PrintFromTopToBottom(tree1);
    }
}

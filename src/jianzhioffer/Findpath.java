package jianzhioffer;

import java.util.ArrayList;

/**
 * Created by thd on 2017/3/4.
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class Findpath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> allpath = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<>();
        if (root == null) return allpath;
        Find(root, target, allpath, path);
        return  allpath;
    }
    public void Find(TreeNode root, int target, ArrayList<ArrayList<Integer>> allpath, ArrayList<Integer> path){
        if (root == null) return;
        if(root.left == null && root.right == null){
            if(root.val == target) {
                path.add(root.val);
                allpath.add(new ArrayList<Integer>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(root.val);
        Find(root.left, target - root.val, allpath, path);
        Find(root.right, target - root.val, allpath, path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args){
        TreeNode tree = new TreeNode(10);
        TreeNode treenode3 = new TreeNode(5);
        TreeNode treenode4 = new TreeNode(12);
        TreeNode treenode5 = new TreeNode(4);
        TreeNode treenode6 = new TreeNode(7);
        tree.left = treenode3;
        tree.right = treenode4;
        treenode3.left = treenode5;
        treenode3.right = treenode6;
        Findpath fp = new Findpath();
        fp.FindPath(tree, 22);


    }
}

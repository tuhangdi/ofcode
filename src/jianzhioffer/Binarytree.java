package jianzhioffer;

/**
 * Created by thd on 2017/2/24.
 */
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
public class Binarytree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return Recursion(pre, in);

    }
    public TreeNode Recursion(int[] pre, int [] in ){
        TreeNode root = new TreeNode(pre[0]);
        int i = 0;
        while(in[i] != pre[0]){
            i++;
        }
        int[] inlefttree = new int[i];
        int[] inrighttree = new int[pre.length - i-1];
        int[] prerighttree = new int[pre.length - i-1];
        int[] prelefttree = new int[i];
        for(int j = 0; j < i; j++){
            prelefttree[j] = pre[j+1];
            inlefttree[j] = in[j];
        }
        for(int j = 0; j<pre.length - i-1;j++){
            prerighttree[j] = pre[i+1+j];
            inrighttree[j] = in[i+1+j];
        }
        if(inlefttree.length != 0){
            root.left = Recursion(prelefttree,inlefttree);
        }
        if(inrighttree.length != 0){
            root.right = Recursion(prerighttree,inrighttree);
        }
        System.out.println(root.val);
        return root;
    }
    public static void main(String[] args){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        Binarytree bt = new Binarytree();
        bt.reConstructBinaryTree(pre,in);
    }
}

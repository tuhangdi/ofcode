package offer2;

import java.util.Arrays;

/**
 * Created by thd on 2017/5/24.
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Sol6 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = new TreeNode(pre[0]);
        int i = 0;
        while (in[i] != pre[0]) i++;
        int[] preLeft = new int[i];
        int[] preRight = new int[pre.length - i - 1];
        int[] inLeft = new int[i];
        int[] inRight = new int[pre.length - i - 1];
        for (int j = 0; j < i; j++) {
            preLeft[j] = pre[j + 1];
            inLeft[j] = in[j];
        }
        for (int j = 0; j < pre.length - i - 1; j++) {
            preRight[j] = in[j + i + 1];
            inRight[j] = in[j + i + 1];
        }
        if (inLeft.length != 0)
            root.left = reConstructBinaryTree(preLeft, inLeft);
        if (inRight.length != 0)
            root.right = reConstructBinaryTree(preRight, inRight);
        System.out.println(root.val);
        return root;

    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        Sol6 bt = new Sol6();
        bt.reConstructBinaryTree(pre, in);
    }
}

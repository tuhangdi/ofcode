package leetcode.Tree;

import org.junit.jupiter.api.Test;

/**
 * Created by thd on 2017/8/21
 * Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

 1
 / \
 2   5
 / \   \
 3   4   6
 The flattened tree should look like:
 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6

 */
public class n114FlattenBinaryTreeToLinkedList {
    TreeNode dummy = null;
    public void flatten(TreeNode root) {//从最后一个结点向上排！！！！！
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = dummy;
        root.left = null;
        dummy = root;
    }

    public void flattenDFS(TreeNode root) {//DFS
        if (root == null) return;
        flattenDFS(root.left);
        flattenDFS(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        while (root.right != null) {//即root存在左孩子
            root = root.right;
        }
        root.right = right;//将root原来的右孩子接到新右孩子
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2;
        t1.right = t5;
        t2.left = t3;
        t2.right = t4;
        t5.right = t6;
        n114FlattenBinaryTreeToLinkedList n = new n114FlattenBinaryTreeToLinkedList();
        n.flattenDFS(t1);


    }
}

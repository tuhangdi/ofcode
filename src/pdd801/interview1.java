package pdd801;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Created by thd on 2017/8/11
 */
public class interview1 {
    public TreeNode addSibling (TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) queue.offer(cur.left);
            if (cur.right != null) queue.offer(cur.right);

            if (queue.isEmpty())
                cur.sibling = null;
            else
                cur.sibling = queue.peek();
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        int[][] n = {
                {1,2,3,4,5,6,1},
                {2,3,4,5,6,1,2},
                {3,4,5,6,1,2,3},
                {4,5,6,1,2,3,4},
                {5,6,1,2,3,4,5},
                {6,1,2,3,4,5,6},
                {1,2,3,4,5,6,8}
        };
        TreeNode t6 = new TreeNode(6);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        interview1 i = new interview1();
        TreeNode t = i.addSibling(t1);
        System.out.println(t.sibling.val);
        System.out.println(t.right.left.sibling);
    }
}

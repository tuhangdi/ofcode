package leetcode.Tree;

import sun.reflect.generics.tree.Tree;

/**
 * Created by thd on 2017/6/21.
 *
 * The thief has found himself a new place for his thievery again.
 * There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house.
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 小偷再次发现自己是一个新的地方。 这个地区只有一个入口，叫做“根”。 除了根，每个房子都有一个只有一个父母房子。
 旅行结束后，聪明的小偷意识到“这个地方的所有房子都形成了二叉树”。 如果在同一天晚上两个直接连接的房屋被打破，它会自动联系警察。

 Determine the maximum amount of money the thief can rob tonight without alerting the police.
 确定小偷今晚可以抢救的最大金额，而不会提醒警方。


 Example 1:
 3
 / \
 2   3
 \   \
 3   1
 Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.


 Example 2:
 3
 / \
 4   5
 / \   \
 1   3   1
 Maximum amount of money the thief can rob = 4 + 5 = 9.


 */
public class n337HouseRobberIII {
    public int rob(TreeNode root) {
        int[] num = dfs(root);
        return Math.max(num[0], num[1]);
    }
    public int[] dfs(TreeNode x) {
        if (x == null) return new int[2];
        int[] left = dfs(x.left);
        int[] right = dfs(x.right);
        int[] res = new int[2];
        res[0] = left[1] + right[1] + x.val;//接受当前节点
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);//不接受当前节点
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.right = node5;

        n337HouseRobberIII n = new n337HouseRobberIII();
        System.out.println(n.rob(node1));
    }

}

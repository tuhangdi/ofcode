package leetcode.HashTable;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by thd on 2017/6/29.
 * Given the root of a tree, you are asked to find the most frequent subtree sum.
 * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).
 * So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 * 给定树的根，要求找到最频繁的子树和。一个节点的子树和定义为植根于该节点（包括节点本身）的子树所形成的所有节点值之和。
 * 那么最频繁的子树总和值是什么呢？如果有一个绑定，以任意顺序返回所有最高频率的值。
 * Examples 1
 Input:

 5
 /  \
 2   -3
 return [2, -3, 4], since all the values happen only once, return all of them in any order.

 Input:

 5
 /  \
 2   -5
 return [2], since 2 happens twice, however -5 only occur once.
 */
public class n508MostFrequentSubtreeSum {
    Map<Integer, Integer> res = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        //countSum(root, res);
        int max = 0;

        for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
            if (entry.getValue() > max) max = entry.getValue();
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
            if (entry.getValue() == max) list.add(entry.getKey());
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    public void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null){
            dfs(root.left);
            root.val += root.left.val;
        }
        if (root.right != null) {
            dfs(root.right);
            root.val += root.right.val;
        }
        if (res.containsKey(root.val)) {
            res.put(root.val, res.get(root.val) + 1);
        }
        else {
            res.put(root.val, 1);
        }

    }

    public int countSum(TreeNode root, HashMap<Integer, Integer> map) {
        int sum = 0;
        sum += root.val;
        if (root.left != null) sum += countSum(root.left, map);
        if (root.right != null) sum += countSum(root.right, map);

        if (map.get(sum) != null) {// 之前放过
            map.put(sum, map.get(sum)+1);
        } else {
            map.put(sum, 1);
        }
        return sum;
    }
}

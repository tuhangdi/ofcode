package leetcode.Tree;

/**
 * Created by thd on 2017/9/4
 *
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 给定二叉搜索树（BST），将其转换为较大的树，使原始BST的每个键都更改为原始键加上所有大于它的键的总和。
 Example:

 Input: The root of a Binary Search Tree like this:
 5
 /   \
 2     13

 Output: The root of a Greater Tree like this:
 18
 /   \
 20     13


 BST，反向中序遍历。跟踪到目前为止已经遍历的所有节点的总和。
 */
public class n538ConvertBSTToGreaterTree {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    public void convert(TreeNode cur) {
        if (cur == null) return;
        convert(cur.right);
        cur.val += sum;
        sum = cur.val;
        convert(cur.left);
    }
}

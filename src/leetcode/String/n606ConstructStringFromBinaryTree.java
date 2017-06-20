package leetcode.String;

/**
 * Created by thd on 2017/6/20.
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

 The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.


 Example 1:
 Input: Binary tree: [1,2,3,4]
   1
 /    \
 2     3
 /
 4

 Output: "1(2(4))(3)"

 Explanation: Originallay it needs to be "1(2(4)())(3()())",
 but you need to omit all the unnecessary empty parenthesis pairs.
 And it will be "1(2(4))(3)".


 Example 2:
 Input: Binary tree: [1,2,3,null,4]
 1
 /   \
 2     3
 \
 4

 Output: "1(2()(4))(3)"

 Explanation: Almost the same as the first example,
 except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
 */
public class n606ConstructStringFromBinaryTree {

    public String tree2str(TreeNode t) {
        if (t == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);
        if (t.left != null && t.right == null) {
            sb.append("(").append(tree2str(t.left)).append(")");
        }
        else if (t.right != null){
            sb.append("(").append(tree2str(t.left)).append(")");
            sb.append("(").append(tree2str(t.right)).append(")");
        }

        return new String(sb);
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;

        n606ConstructStringFromBinaryTree n = new n606ConstructStringFromBinaryTree();
        System.out.println(n.tree2str(node1));
    }
}

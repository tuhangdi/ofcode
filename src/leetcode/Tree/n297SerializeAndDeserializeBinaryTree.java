package leetcode.Tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by thd on 2017/8/29
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 序列化是将数据结构或对象转换成比特序列的过程，使得其可以存储在文件或存储器缓冲器中，或者通过网络连接链路传输，以便在相同或另一个计算机环境中稍后重构。
 Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 设计一个将二进制树序列化和反序列化的算法。 对序列化/反序列化算法的工作方式没有任何限制。 您只需要确保二进制树可以序列化为一个字符串，并且该字符串可以反序列化到原始的树结构。
 For example, you may serialize the following tree

 1
 / \
 2   3
    / \
    4   5
 as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

 以先序遍历打印树，并使用“X”表示空节点，用“，”的分割节点。 我们可以使用StringBuilder来构建字符串。
 对于反序列化，我们使用队列来存储预订遍历，并且由于我们将“X”作为空节点，所以我们知道如何结束构造子节点。
 */
public class n297SerializeAndDeserializeBinaryTree {
    private static final String spliter = ",";
    private static final String NN = "X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }
    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}

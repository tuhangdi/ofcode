package leetcode.DFS;

import java.util.*;

/**
 * Created by thd on 2017/9/5
 * For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 对于具有树特征的无向图，我们可以选择任何节点作为根。 结果图就是根树。
 在所有可能有根的树中，具有最小高度的树称为最小高度树（MHT）。 给出这样的图形，写一个函数来查找所有的MHT并返回一个他们的根标签的列表。
 Format
 The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 该图包含从0到n - 1标记的n个节点。将给出数字n和无向边的列表（每个边是一对标签）。
 You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 您可以假设边缘中不会出现重复的边。 由于所有边都是无向的，所以[0,1]与[1，0]相同，因此不会一起显示在边。
 Example 1:

 Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

 0
 |
 1
 / \
 2   3
 return [1]

 Example 2:

 Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

 0  1  2
 \ | /
 3
 |
 4
 |
 5
 return [3, 4]


 对于一棵树，我们从每一端开始，端指的是度为1的节点（即叶子节点）。我们让指针移动速度相同。当两个指针相遇时，我们只保留其中一个指针，直到最后两个指针相交或离开一步，然后找到根。

 很容易看出，最后两个指针来自图形中最长路径的两端。实际实现类似于BFS拓扑分类。删除叶子，更新内部顶点的度数。然后删除新的叶子。按度进行，直到剩下2个或1个节点为止。剩下的是我们的答案！

 时间复杂度和空间复杂度都是O（n）。
 */
public class n310MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (adj.get(i).size() == 1) leaves.add(i);

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}

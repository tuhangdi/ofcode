package leetcode.DFS;

/**
 * Created by thd on 2017/7/5.
 * There are N students in a class. Some of them are friends, while some are not.
 * Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.

 Given a N*N matrix M representing the friend relationship between students in the class.
 If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not.
 And you have to output the total number of friend circles among all the students.
 * 班上有N名学生。 其中有些是朋友，有些则不是朋友。 他们的友谊本质上是传递性的。
 * 例如，如果A是B的直接朋友，B是C的直接朋友，那么A是C的间接朋友。我们定义一个朋友圈是一群直接或间接的朋友的学生。
 * 给出一个N * N矩阵M代表班级学生之间的朋友关系。 如果M [i] [j] = 1，那么第i和第j个学生是彼此的直接朋友，否则不是。
 * 你必须输出所有学生中朋友圈的总数。
 *
 *
 * Note:
 N is in range [1,200].
 M[i][i] = 1 for all students.
 If M[i][j] = 1, then M[j][i] = 1.

 * Example 1:
 Input:
 [[1,1,0],
 [1,1,0],
 [0,0,1]]
 Output: 2
 Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 The 2nd student himself is in a friend circle. So return 2.


 Example 2:
 Input:
 [[1,1,0],
 [1,1,1],
 [0,1,1]]
 Output: 1
 Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 *
 * 题解：图论，给定邻接矩阵M，求连通分量的个数。  算法1.5 united-find算法求连通分量。
 * 声明一个visited，用于记录遍历过的行。每次dfs找到一个原矩阵为1的位置（除了对角线），就把这个位置的列数变成行数再dfs，
 * 如果是在同一个圈里，最终会绕回已经遍历过的行，visited为true，return 0；如果不是同一个圈，则增加1。
 */


public class n547FriendCircles
{
    //quick-find算法
    public int findCircleNum(int[][] M) {
        int[] id = new int [M.length];
        int count = M.length;
        for (int i = 0; i < M.length; i++) {
            id[i] = i;
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 1) {   //union
                    int pRoot = find(id, i);
                    int qRoot = find(id, j);
                    if (pRoot != qRoot) {
                        id[pRoot] = qRoot;
                        count --;
                    }
                }
            }
        }
        return count;
    }
    private int find(int[] id, int p) {
        while (p != id[p]){
            p = id[p];
        }
        return p;
    }
}

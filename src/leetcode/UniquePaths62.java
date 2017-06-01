package leetcode;

/**
 * Created by thd on 2017/6/1.
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * m x n的方格矩阵，从左上要右下，只能向下或者向右移动，有多少种可能的走法。
 * 题意：数组 A[m][n] ，从 A[0][0] 到 A[m-1][n-1] 有多少条路径
 * <p>
 * 对于格点(i,j)。由于只能从上格点(i-1,j)或左格点(i,j-1)到达，并且两者路径是不重复的
 * 因此path[i][j] = path[i-1][j]+path[i][j-1]
 */
public class UniquePaths62 {

    public int uniquePaths(int m, int n) {
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) a[i][j] = 1;
                else a[i][j] = a[i - 1][j] + a[i][j - 1];
            }
        }
        return a[m - 1][n - 1];
    }
    //优化内存的dp。
    public int uniqurPathsOne(int m, int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                a[j] += a[j - 1];
            }
        }
        return a[n - 1];
    }

    public static void main(String[] args) {
        UniquePaths62 u = new UniquePaths62();
        System.out.println(u.uniquePaths(3, 7));
        System.out.println(u.uniqurPathsOne(3, 7));
    }
}

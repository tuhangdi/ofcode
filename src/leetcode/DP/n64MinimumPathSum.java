package leetcode.DP;

/**
 * Created by thd on 2017/6/2.
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * 给定一个充满非负数的网格，找到一个从左上到右下的路径，最小化沿其路径的所有数字的总和。
 * Note: You can only move either down or right at any point in time.
 *
 */
public class n64MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        res[0][0] = grid[0][0];
        //要考虑边界
        for (int i = 1; i < m; i++) {//第一列
            res[i][0] = res[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {//第一行
            res[0][i] = res[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
            }
        }
        return res[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{0}};
        n64MinimumPathSum n = new n64MinimumPathSum();
        System.out.println(n.minPathSum(grid));
    }
}

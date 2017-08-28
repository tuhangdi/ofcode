package leetcode.DP;

import org.junit.jupiter.api.Test;

/**
 * Created by thd on 2017/8/28
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 给定填充0和1的二维二进制矩阵，找到只有1的最大平方并返回其面积。
 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 Return 4.
 Credits:
 Special thanks to @Freezen for adding this problem and creating all test cases.

 上侧，左侧和左上角决定平方的大小。如果它们都相同，则增加1.如果它们不相同，则它们的最小值增加1。
 dp[i][j]表示以位置（i,j）结尾的最大正方形的边长
 */
public class n221MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1' ) {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }

    @Test
    public void test() {
        char[][] n = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(n));
    }
}

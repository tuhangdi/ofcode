package leetcode.DP;

/**
 * Created by thd on 2017/6/1.
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * 现在考虑如果网格中添加了一些障碍。 有多少独特的路径呢？
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 障碍物和空格分别在网格中标记为1和0。
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * <p>
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * <p>
 * Note: m and n will be at most 100.
 */
public class n63UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) dp[j] = 0;
                else{
                    if (j > 0) {
                        dp[j] += dp[j - 1];
                    }
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[][] a = {{0,0}};
        n63UniquePathsII u = new n63UniquePathsII();
        System.out.println(u.uniquePathsWithObstacles(a));
    }
}

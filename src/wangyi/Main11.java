package wangyi;

import java.util.Scanner;

/**
 * Created by thd on 2017/5/16.
 * [编程题] 堆砖块
 * 时间限制：1秒
 * 空间限制：32768K
 * 小易有n块砖块，每一块砖块有一个高度。
 * 小易希望利用这些砖块堆砌两座相同高度的塔。
 * 为了让问题简单，砖块堆砌就是简单的高度相加，某一块砖只能使用在一座塔中一次。
 * 小易现在让能够堆砌出来的两座塔的高度尽量高，小易能否完成呢。
 * 输入描述:
 * 输入包括两行：
 * 第一行为整数n(1 ≤ n ≤ 50)，即一共有n块砖块
 * 第二行为n个整数，表示每一块砖块的高度height[i] (1 ≤ height[i] ≤ 500000)
 * <p>
 * <p>
 * 输出描述:
 * 如果小易能堆砌出两座高度相同的塔，输出最高能拼凑的高度，如果不能则输出-1.
 * 保证答案不大于500000。
 * <p>
 * 输入例子:
 * 3
 * 2 3 5
 * <p>
 * 输出例子:
 * 5
 *
 *
 *
 *  思路：动态规划好题。dp(i, j)表示考虑前i个砖块，两堆砖块的高度差为j的最大高度。用滚动数组优化下内存，注意下边界。
 */
public class Main11 {
    public static void main(String[] args) {
        int max = 500005;
        int[][] dp = new int[2][max];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[55];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            height[i] = sc.nextInt();
            sum += height[i];
        }
        for(int i =0; i < 2;i++){
            for(int j = 0;j <max;j++){
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;
        int f = 1;
        int lim = Math.min(max, sum / 2);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= lim; j++) {
                dp[f][j] = dp[1 - f][j];
                if (j - height[i] <= 0 && dp[1 - f][height[i] - j] >= 0)
                    dp[f][j] = Math.max(dp[f][j], dp[1 - f][height[i] - j] + j);
                if (j - height[i] > 0 && dp[1 - f][j - height[i]] >= 0)
                    dp[f][j] = Math.max(dp[f][j], dp[1 - f][j - height[i]] + height[i]);
                if (j + height[i] <= lim && dp[1 - f][j + height[i]] != 0)
                    dp[f][j] = Math.max(dp[f][j], dp[1 - f][j + height[i]]);
            }
            f =1-f;
        }
        if(dp[1-f][0] != 0) System.out.println(dp[1-f][0]);
        else System.out.println(-1);
    }
}

package leetcode;

/**
 * Created by thd on 2017/6/1.
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * 爬楼梯，可以爬1步或2步，有多少种爬到顶的方式。
 * 思路：斐波那契数列。。。。。
 */
public class ClimbingStairs70 {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n - 1];
    }
}

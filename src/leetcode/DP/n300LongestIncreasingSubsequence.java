package leetcode.DP;

import java.util.Arrays;

/**
 * Created by thd on 2017/8/29
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 给定一个未排序的整数数组，找到最长增长子序列的长度。
 For example,
 Given [10, 9, 2, 5, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 最长的增长次序是[2,3,7,101]，因此长度为4.请注意，可能有多个LIS组合，只需要返回长度。
 Your algorithm should run in O(n2) complexity.

 Follow up: Could you improve it to O(n log n) time complexity?
 */
public class n300LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;

        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }
        int longest = 0;
        for (int i = 0; i < dp.length; i++) {
            longest = Math.max(longest, dp[i]);
        }
        return longest;
    }


    public int lengthofLISBinary(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if (i < 0) i = -(i + 1);
            dp[i] = x;
            if (i == len) len++;
        }
        return len;
    }
}

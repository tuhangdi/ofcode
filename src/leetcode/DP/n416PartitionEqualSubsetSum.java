package leetcode.DP;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by thd on 2017/9/4
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 给定一个仅包含正整数的非空数组，查找数组是否可以划分成两个子集，以使两个子集中的元素之和相等。
 Note:
 Each of the array element will not exceed 100.
 The array size will not exceed 200.
 Example 1:

 Input: [1, 5, 11, 5]

 Output: true

 Explanation: The array can be partitioned as [1, 5, 5] and [11].
 Example 2:

 Input: [1, 2, 3, 5]

 Output: false

 Explanation: The array cannot be partitioned into equal sum subsets.


 01背包
 */
public class n416PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum /= 2;

        int n = nums.length;
        boolean[] dp = new boolean[sum + 1];

        dp[0] = true;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = sum; j >= nums[i - 1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i - 1]];
            }
        }
        return dp[sum];
    }
}

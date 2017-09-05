package leetcode.DP;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Created by thd on 2017/9/4
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
 给定一个具有所有正数且不存在重复值的整数数组，找到可以组合为正整数目标的可能组合数。
 Example:

 nums = [1, 2, 3]
 target = 4

 The possible combination ways are:
 (1, 1, 1, 1)
 (1, 1, 2)
 (1, 2, 1)
 (1, 3)
 (2, 1, 1)
 (2, 2)
 (3, 1)

 Note that different sequences are counted as different combinations.

 请注意，不同的序列被计为不同的组合。
 Therefore the output is 7.



 我们知道目标是数组中数字的总和。想象一下，我们只需要一个数字来达到目标​​，这个数字可以是数组中的任何一个，对吧？所以目标，comb [target] = sum（comb [target-nums [i]]）的组合数目，其中0 <= i <nums.length，target> = nums [i]。

 在给出的例子中，我们实际上可以找到4的组合数为3（4 - 1），2（4- 2）和1（4 - 3）。结果，comb[4] =comb[4-1] +comb[4-2] +comb[4-3] =comb[3] +comb[2] +comb[1]。

 然后考虑基本情况。因为如果目标是0，则只有一种方法可以得到零，那就是使用0，我们可以设置comb [0] = 1。
 */
public class n377CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, dp, target);
    }
    private int helper(int[] nums, int[] dp, int target) {
        if (dp[target] != -1)
            return dp[target];

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += helper(nums, dp, target - nums[i]);
            }
        }
        dp[target] = res;
        return res;
    }

    @Test
    public void test() {
        int[] nums = {1,2,3};
        System.out.println(combinationSum4(nums, 32));
    }
}

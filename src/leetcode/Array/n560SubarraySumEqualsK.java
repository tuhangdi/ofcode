package leetcode.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by thd on 2017/9/4
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 给定整数数组和整数k，您需要找到总和等于k的连续子数组的总数。
 Example 1:
 Input:nums = [1,1,1], k = 2
 Output: 2
 Note:
 The length of the array is in range [1, 20,000].
 The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

 解决这个问题的关键是SUM [i，j]。 所以如果我们知道SUM [0，i-1]和SUM [0，j]，那么我们可以很容易地得到SUM [i，j]。
 为了实现这一点，我们只需要遍历数组，计算当前的总和并将所有看到的PreSum的数量保存到HashMap。 时间复杂度O（n），空间复杂度O（n）。
 */
public class n560SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            if (preSum.containsKey(sum))
                preSum.put(sum, preSum.get(sum) + 1);
            else
                preSum.put(sum, 1);
        }
        return result;
    }

    public static void main(String[] args) {
        n560SubarraySumEqualsK n = new n560SubarraySumEqualsK();
        int[] num = new int[]{1,1,1,1,1};
        System.out.println(n.subarraySum(num, 2));
    }
}

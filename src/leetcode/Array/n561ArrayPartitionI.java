package leetcode.Array;

import java.util.Arrays;

/**
 * Created by thd on 2017/6/9.
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * 给定一个2n个整数的数组，你的任务是将这些整数分成n对整数，如（a1，b1），（a2，b2），...，（an，bn），取每组中较小的值，使得这些值的总和最大。
 * Example 1:
 * Input: [1,4,3,2]
 *
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4.
 * Note:
 * n is a positive integer, which is in the range of [1, 10000].
 * All the integers in the array will be in the range of [-10000, 10000].
 */
public class n561ArrayPartitionI {
    public int arrayPairSum(int[] nums) {//排序后，0，2，4。。。即是pair中的较小值
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,3,2};
        n561ArrayPartitionI n = new n561ArrayPartitionI();
        System.out.println(n.arrayPairSum(nums));
    }
}

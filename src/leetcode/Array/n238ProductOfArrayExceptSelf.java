package leetcode.Array;

/**
 * Created by thd on 2017/8/29
 *
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 给定n个整数的数组，其中n> 1，nums返回数组输出，使得output[i]等于nums [i]之外的所有元素的乘积。
 Solve it without division and in O(n).

 For example, given [1,2,3,4], return [24,12,8,6].

 Follow up:
 Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 你可以用恒定的空间复杂度来解决它吗？ （注意：为了进行空间复杂性分析，输出数组不算作额外的空间。）
 */
public class n238ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int temp = 1;
        for (int i = 0; i < nums.length; i++) { //res[i]的结果是前面所有数的乘积，不包括nums[i]
            res[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {//从后往前乘，注意忽略nums[i]
            res[i] *= temp;
            temp *= nums[i];
        }
        return res;
    }
}

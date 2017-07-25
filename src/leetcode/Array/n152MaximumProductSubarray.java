package leetcode.Array;

/**
 * Created by thd on 2017/7/25
 *Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 找到数组中包含最大乘积的数组（包含至少一个数字）中的连续子阵列。
 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6.


 dp优化，找到当前最小值和最大值，下一个位置的最大值可能是当前最小值*这个位置 或者 这个位置的值 或者 这个位置的值*当前最大值
 */
public class n152MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int prePos = nums[0];
        int preNeg = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int pos = prePos * nums[i];
            int neg = preNeg * nums[i];
            prePos = Math.max(Math.max(pos, neg), nums[i]);//以i结束的最大值
            preNeg = Math.min(Math.min(pos, neg), nums[i]);//以i结束的最小值
            res = Math.max(prePos, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,3,-2,4};
        n152MaximumProductSubarray n = new n152MaximumProductSubarray();
        System.out.println(n.maxProduct(nums));
    }
}

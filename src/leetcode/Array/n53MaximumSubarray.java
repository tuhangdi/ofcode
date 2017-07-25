package leetcode.Array;

/**
 * Created by thd on 2017/6/2.
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 在数组中找到连续的子阵列（包含至少一个数字），其数最大。
 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.

 动态规划。维护两个变量，一个是全局最优，就是到当前元素为止最优的解是，一个是局部最优，就是必须包含当前元素的最优的解。
 */
public class n53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int gmax = nums[0];
        int lmax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            lmax = Math.max(nums[i],nums[i]+lmax);
            gmax = Math.max(gmax,lmax);
        }
        return gmax;
    }

    public static void main(String[] args) {
        int [] nums = {0};
        n53MaximumSubarray n = new n53MaximumSubarray();
        System.out.println(n.maxSubArray(nums));
    }
}

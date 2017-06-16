package leetcode.Array;

/**
 * Created by thd on 2017/6/15.
 * Given an unsorted integer array, find the first missing positive integer.
 * 给定一个未排序的整数数组，找到第一个缺失的正整数。
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * <p>
 * Your algorithm should run in O(n) time and uses constant space.
 * 您的算法应在O（n）时间运行，并使用恒定空间。
 * <p>
 * 思路：交换数组元素，使得数组中第i位存放数值(i+1)。
 * 最后遍历数组，寻找第一个不符合此要求的元素，返回其下标。
 * 整个过程需要遍历两次数组，复杂度为O(n)。
 */
public class n41FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[i] > 0 && nums[i] <= nums.length) {
                int temp = nums[i];
                if (nums[temp - 1] == temp) break;//相等时，证明已在正确位置，不需要移动，避免死循环
                nums[i] = nums[temp -1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return (i + 1);
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        n41FirstMissingPositive n = new n41FirstMissingPositive();
        int[] nums = {3,4,-1,1};
        System.out.println(n.firstMissingPositive(nums));
    }
}

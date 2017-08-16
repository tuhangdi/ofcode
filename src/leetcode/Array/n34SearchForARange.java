package leetcode.Array;

import org.junit.jupiter.api.Test;

/**
 * Created by thd on 2017/8/16
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 给定按升序排序的整数数组，找到给定目标值的起始和终止位置。

 Your algorithm's runtime complexity must be in the order of O(log n).
 您的算法的运行时复杂度必须是O（log n）的顺序。
 If the target is not found in the array, return [-1, -1].
 如果在数组中找不到目标，则返回[-1，-1]。

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].

 */
public class n34SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int start = firstGreaterOrEqual(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[] {start, firstGreaterOrEqual(nums, target + 1) - 1};
    }

    public int firstGreaterOrEqual(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    @Test
    public void test() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        for (int i : searchRange(nums, 4))
            System.out.println(i);
    }
}

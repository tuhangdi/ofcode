package leetcode.Array;

/**
 * Created by thd on 2017/9/4
 *
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 给定一个整数数组，你需要找到一个连续的子数组，如果你只按升序对这个子数组进行排序，那么整个数组也按升序进行排序。

 You need to find the shortest such subarray and output its length.
 您需要找到最短的子序列并输出其长度。
 Example 1:
 Input: [2, 6, 4, 8, 10, 9, 15]
 Output: 5
 Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 Note:
 Then length of the input array is in range [1, 10,000].
 The input array may contain duplicates, so ascending order here means <=.

 维持两个变量，beg表示左侧所有的元素在右边都没有更小的元素，end表示右侧所有的元素在左边没有更大的元素，beg从右向左遍历，end从左向右遍历。
 */
public class n581ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length, beg = -1, end = -2, min = nums[n - 1], max = nums[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - i - 1]);
            if (nums[i] < max) end = i;
            if (nums[n - i - 1] > min) beg = n - i - 1;
        }
        return end - beg + 1;
    }

    public static void main(String[] args) {
        n581ShortestUnsortedContinuousSubarray n = new n581ShortestUnsortedContinuousSubarray();
        int[] nums = {2,6,4,8,10,9,15};
        System.out.println(n.findUnsortedSubarray(nums));
    }
}

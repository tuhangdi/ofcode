package leetcode.Array;

/**
 * Created by thd on 2017/9/4
 *
 * Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.
 给定一个排序数组，它只包含整数，每个元素出现两次，只有一个出现一次的元素。 找到只显示一次的单个元素。
 Example 1:
 Input: [1,1,2,3,3,4,4,8,8]
 Output: 2
 Example 2:
 Input: [3,3,7,7,10,11,11]
 Output: 10
 Note: Your solution should run in O(log n) time and O(1) space.
 注意：您的解决方案应在O（log n）时间和O（1）空间中运行。
 */
public class n540SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            // We want the first element of the middle pair,
            // which should be at an even index if the left part is sorted.
            // Example:
            // Index: 0 1 2 3 4 5 6
            // Array: 1 1 3 3 4 8 8

            int mid = (lo + hi) / 2;
            if (mid % 2 == 1) mid--;

            // We didn't find a pair. The single element must be on the left.
            // (pipes mean start & end)
            // Example: |0 1 1 3 3 6 6|
            //               ^ ^
            // Next:    |0 1 1|3 3 6 6
            if (nums[mid] != nums[mid + 1])
                hi = mid;

            // We found a pair. The single element must be on the right.
            // Example: |1 1 3 3 5 6 6|
            //               ^ ^
            // Next:     1 1 3 3|5 6 6|
            else
                lo = mid + 2;
        }
        // 'lo' should always be at the beginning of a pair.
        // When 'lo > hi', start must be the single element.
        return nums[lo];
    }
}

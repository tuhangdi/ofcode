package leetcode.Array;


import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by thd on 2017/8/29
 *
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 给定一个数组nums，有一个大小为k的滑动窗口从数组的左边移动到右边。 您只能在窗口中看到k个数字。 每次滑动窗口向右移动一个位置。

 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 给定nums = [1,3，-1，-3,5,3,6,7]和k = 3。
 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 Therefore, return the max sliding window as [3,3,5,5,6,7].
 因此，最大滑动窗口返回[3,3,5,5,6,7]。
 Note:
 You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

 Follow up:
 Could you solve it in linear time?
 */
public class n239SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];

        int n = nums.length;
        Deque<Integer> q = new LinkedList<>();
        int[] res = new int[n - k + 1];
        int t = 0;
        for (int i = 0; i < n; i++) {

            while (!q.isEmpty() && q.peekLast() < nums[i]) {//使当前最大值一直在队列头
                q.pollLast();
            }

            q.offerLast(nums[i]);

            if (i > k - 1 && q.peekFirst() == nums[i - k]) {//如果最大值不在窗口了，需要移除
                q.pollFirst();
            }

            if (i >= k - 1) {
                res[t++] = q.peekFirst();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        n239SlidingWindowMaximum n = new n239SlidingWindowMaximum();
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(n.maxSlidingWindow(nums, k));
    }
}

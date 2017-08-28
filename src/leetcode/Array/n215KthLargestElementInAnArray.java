package leetcode.Array;

import java.util.PriorityQueue;

/**
 * Created by thd on 2017/8/28
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 查找未排序数组中的第k大的元素。
 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.

 Credits:
 Special thanks to @mithmatt for adding this problem and creating all test cases.


topK,快排的partition过程
 */
public class n215KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {//O(N) best case / O(N^2) worst case running time + O(1) memory,先随机化可以O（N）
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int j = partition(nums, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else
                break;
        }
        return nums[k];
    }
    private int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (a[++i] < a[lo]) if (i == hi) break;
            while (a[lo] < a[--j]) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);//将标志位放到正确的位置
        return j;
    }
    private void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }




    public int findKthLargestPri(int[] nums, int k) {//O(N lg K) running time + O(K) memory
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int val : nums) {
            queue.offer(val);
            if (queue.size() > k)
                queue.poll();
        }
        return queue.peek();
    }
}

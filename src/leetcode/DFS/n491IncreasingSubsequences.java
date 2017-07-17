package leetcode.DFS;

import java.util.*;

/**
 * Created by thd on 2017/7/17.
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2 .
 * 给定一个整数数组，您的任务是找到给定数组的所有不同可能增加的子序列，增加子序列的长度应至少为2。
 * Example:
 * Input: [4, 6, 7, 7]
 * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * Note:
 * The length of the given array will not exceed 15.
 * The range of integer in the given array is [-100,100].
 * The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
 */
public class n491IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        LinkedList<Integer> hold = new LinkedList<>();
        helper(hold, set, nums, 0);
        List res = new ArrayList(set);
        return res;
    }

    public void helper(LinkedList<Integer> hold, Set<List<Integer>> set, int[] nums, int index) {
        if (hold.size() >= 2)
            set.add(new LinkedList<>(hold));
        for (int i = index; i < nums.length; i++) {
            if (hold.size() == 0 || hold.get(hold.size() - 1) <= nums[i]) {
                hold.add(nums[i]);
                helper(hold, set, nums, i + 1);
                hold.remove(hold.size() - 1);
            }
        }
    }
}

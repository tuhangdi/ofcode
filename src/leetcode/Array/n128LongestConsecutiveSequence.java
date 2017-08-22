package leetcode.Array;




import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * Created by thd on 2017/8/21
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 给定一个未排序的整数数组，找出最长连续元素序列的长度。
 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 连续元数最长的序列是[1,2,3,4]。 返回长度：4。
 Your algorithm should run in O(n) complexity.


 */
public class n128LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n - 1)) ? map.get(n + 1) : 0;

                int sum = left + right + 1;
                map.put(n, sum);

                res = Math.max(res, sum);

                map.put(n - left, sum);
                map.put(n + right, sum);
            }
            else {
                continue;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        longestConsecutive(nums);
    }
}

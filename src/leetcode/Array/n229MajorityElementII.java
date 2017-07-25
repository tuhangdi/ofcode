package leetcode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thd on 2017/7/24
 *
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * The algorithm should run in linear time and in O(1) space.
 */
public class n229MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int count1 = 0, count2 = 0;
        int candidate1 = nums[0], candidate2 = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (candidate1 == nums[i])
                count1++;
            else if (candidate2 == nums[i])
                count2++;
            else if (count1 == 0) {
                candidate1 = nums[i];
                count1++;
            }
            else if (count2 == 0) {
                candidate2 = nums[i];
                count2++;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (candidate1 == nums[i])
                count1++;
            else if (candidate2 == nums[i])
                count2++;
        }
        if (count1 > nums.length/3)
            res.add(candidate1);
        if (count2 > nums.length/3)
            res.add(candidate2);
        return res;
    }
}

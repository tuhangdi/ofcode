package leetcode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thd on 2017/6/15.
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 给定一个整数数组，其中1≤a[i]≤n（n =数组大小），某些元素出现两次，而其他元素出现一次。
 Find all the elements of [1, n] inclusive that do not appear in this array.

 找到不出现在这个数组中的[1，n]包含的所有元素。
 Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 你可以在没有额外空间且O(n)运行时间的情况下运行吗？ 您可以假设返回的列表不计入额外的空间。
 Example:

 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [5,6]

 与n442类似,也是采用正负号标记法。遍历两次数组，第一次将出现过的元素的位置标为负，第二次将为正的值放入返回列表。
 */
public class n448FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) nums[index] = - nums[index];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) res.add(i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        n448FindAllNumbersDisappearedInAnArray  n = new n448FindAllNumbersDisappearedInAnArray();
        List<Integer> res = n.findDisappearedNumbers(nums);
        for (Integer r : res) {
            System.out.println(r);
        }
    }
}

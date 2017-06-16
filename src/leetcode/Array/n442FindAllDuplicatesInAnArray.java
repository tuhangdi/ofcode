package leetcode.Array;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by thd on 2017/6/15.
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 给定整数数组，1≤a[i]≤n（n =数组大小），有些元素出现两次，其他元素出现一次。
 Find all the elements that appear twice in this array.
 找到在这个数组中出现两次的所有元素。
 Could you do it without extra space and in O(n) runtime?
 你可以在没有额外空间并且O(n)下完成吗？
 Example:
 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [2,3]

 问题的关键在于1≤a[i]≤n，即数组中的值不大于数组大小，采用正负号标记法。
 */


public class n442FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if  (nums[index] < 0) res.add(index + 1);
            nums[index] = - nums[index];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        n442FindAllDuplicatesInAnArray n = new n442FindAllDuplicatesInAnArray();
        List<Integer> res = n.findDuplicates(nums);
        for (Integer r : res){
            System.out.println(r);
        }
    }
}

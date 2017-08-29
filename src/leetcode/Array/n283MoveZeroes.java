package leetcode.Array;

/**
 * Created by thd on 2017/8/29
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 给定一个数组nums，写一个函数将所有的0移动到它的最后，同时保持非零元素的相对顺序。
 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 例如，给定nums = [0，1，0，3，12]，在调用函数之后，nums应该是[1,3，12，0，0]。
 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.


 */
public class n283MoveZeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) nums[j++] = nums[i];
        }
        while (j < nums.length)
            nums[j++] = 0;
    }
}

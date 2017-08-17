package leetcode.Array;

import org.junit.jupiter.api.Test;

/**
 * Created by thd on 2017/8/17
 *
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 给定一个n个对象颜色为红，白或蓝的数组，对它们进行排序，使相同颜色的对象相邻，颜色为红，白，蓝。
 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 在这里，我们将使用0，1和2的整数分别表示红色，白色和蓝色。
 Note:
 You are not suppose to use the library's sort function for this problem.
 你不认为使用库的排序功能来解决这个问题。

 */
public class n75SortColors {
    public void sortColors(int[] nums) {
        if (nums.length == 0 || nums == null || nums.length == 1) return;
        int zero = 0, two = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] == 2 && i < two) swap(nums, i, two--);
            while (nums[i] == 0 && i > zero) swap(nums, i, zero++);
        }

//        for (int k : nums)
//            System.out.println(k);
    }
    public void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test() {
        int[] nums = {2, 1, 0, 2};
        sortColors(nums);
    }
}

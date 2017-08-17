package leetcode.Array;

import org.junit.jupiter.api.Test;

/**
 * Created by thd on 2017/8/17
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 给定一组非负整数，您最初位于数组的第一个索引处。
 Each element in the array represents your maximum jump length at that position.
 阵列中的每个元素代表您在该位置的最大跳转长度
 Determine if you are able to reach the last index.
 确定你是否能够达到最后一个索引。
 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false.
 */
public class n55JumpGame {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) return false;
            max = Math.max(max, nums[i] + i);//维护最远能走到的位置
        }
        return true;
    }

    @Test
    public void test() {
        int[] nums = new int[] {3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }
}

package leetcode.Array;

/**
 * Created by thd on 2017/6/15.
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * 给定一个包含从0，1，2，...，n中取出的n个不同数字的数组，找到数组中缺少的元素。
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * <p>
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 * 您的算法应该运行在线性运行时的复杂性。 你可以使用只有恒定的额外的空间复杂性实现它吗？
 * 思路：n41的条件简化版，交换数组元素，使得数组中第i位存放数值(i+1)。
 * 最后遍历数组，寻找不符合此要求的元素，返回其下标。
 * 整个过程需要遍历两次数组，复杂度为O(n)。
 */
public class n268MissingNumber {
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i && nums[i] < nums.length) {
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }

        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums.length;
    }

    public static void main(String[] args) {
        n268MissingNumber n = new n268MissingNumber();
        int[] nums = {0, 4, 3, 5, 2};
        System.out.println(n.missingNumber(nums));
    }
}

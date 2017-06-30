package leetcode.HashTable;

/**
 * Created by thd on 2017/6/27.
 * Given an array of integers, every element appears twice except for one. Find that single one.
 给定整数数组，除了一个元素之外，每个元素都会出现两次。 找到那个单一的。
 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 您的算法应具有线性运行时复杂度。 你可以实现它而不使用额外的内存吗？
 */
public class n136SingleNumber {
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3};
        n136SingleNumber n = new n136SingleNumber();
        System.out.println(n.singleNumber(nums));
    }
}

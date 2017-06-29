package leetcode.HashTable;

/**
 * Created by thd on 2017/6/27.
 * Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 给定整数数组，每个元素出现三次，除了一个出现恰好一次。 找到那个单一的。
 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 您的算法应具有线性运行时复杂度。 你可以实现它而不使用额外的内存吗？

 思路：模拟二进制，每个位应该是3的倍数，余数就是只出现一次的数
 */
public class n137SingleNumberII {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        int result = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < nums.length; j++) {
                count[i] += ((nums[j] >> i) & 1);//把输入数字的i位相加
                count[i] = count[i] % 3;
            }
            result |= (count[i] << i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,3,3,3};
        n137SingleNumberII n = new n137SingleNumberII();
        System.out.println(n.singleNumber(nums));
    }
}

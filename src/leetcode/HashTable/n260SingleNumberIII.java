package leetcode.HashTable;

/**
 * Created by thd on 2017/6/27.
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * 给定一个数组，其中只有两个元素只显示一次，而所有其他元素出现两次。 找到只出现一次的两个元素。
 *
 * For example:

 Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

 Note:
 The order of the result is not important. So in the above example, [5, 3] is also correct.
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

 思路：1.先还是xor。
 2.我们可以将数组分成两个部分，每个部分里只有一个元素出现一次，其余元素都出现两次。那么使用这种方法就可以找出这两个元素了。
 不妨假设这两个元素是x，y,而且x!=y，那么最终所有的元素异或的结果就是res = x^y.很显然，res!= 0，如果res=0，那么x=y，与题意不符。
 既然res！=0，那么我们可以找出其二进制表示中的某一位是1，我们从低位往高位找，找到第一个二进制位是1的位置。
 对于原来的数组，我们可以根据这个位置是不是1就可以将数组分成两个部分。
 x，y在不同的两个子数组中。而且对于其他成对出现的元素，要么在x所在的那个数组，要么在y所在的那个数组。
 假设不是的话，那说明这一对数在这一位上一个是0一个是1，很显然不符它们是一对相等数的条件。

 */
public class n260SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        int flag = 1;
        while ((flag & res) == 0) {//从低到高找1
            flag <<= 1;
        }

        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & flag) == 0)
                result[0] ^= nums[i];
            else
                result[1] ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        n260SingleNumberIII n = new n260SingleNumberIII();
        int[] nums = {1,2,1,3,2,5};
        for (int num : n.singleNumber(nums))
            System.out.println(num);
    }
}

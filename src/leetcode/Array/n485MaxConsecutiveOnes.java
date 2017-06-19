package leetcode.Array;

/**
 * Created by thd on 2017/6/19.
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 给定二进制数组，找到此数组中连续1的最大数。
 Example 1:
 Input: [1,1,0,1,1,1]
 Output: 3
 Explanation: The first two digits or the last three digits are consecutive 1s.
 The maximum number of consecutive 1s is 3.
 Note:

 The input array will only contain 0 and 1.
 The length of input array is a positive integer and will not exceed 10,000
 *
 */
public class n485MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) res ++;
            else{
                max = Math.max(res, max);
                res = 0;
            }
        }
        max = Math.max(res, max);
        return max;
    }

    public static void main(String[] args) {
        n485MaxConsecutiveOnes n = new n485MaxConsecutiveOnes();
        int[] nums = {1,0,1,1,0,1};
        System.out.println(n.findMaxConsecutiveOnes(nums));
    }
}

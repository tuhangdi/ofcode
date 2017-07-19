package leetcode.String;

/**
 * Created by thd on 2017/7/18.
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 给定一个已经按升序排序的整数数组，找到两个数字，使它们相加到一个特定的目标数。
 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 函数twoSum应该返回两个数字的索引，使它们相加到目标，其中index1必须小于index2。 请注意，您返回的答案（index1和index2）都不是基于零的。
 You may assume that each input would have exactly one solution and you may not use the same element twice.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */
public class n167TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int f = 0;
        int l = numbers.length - 1;

        while (f < l) {
            int v = numbers[f] + numbers[l];
            if (v == target) {
                res[0] = f + 1;
                res[1] = l + 1;
                break;
            } else if (v > target) {
                l--;
            } else {
                f++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        n167TwoSumII n = new n167TwoSumII();
        for (int i : n.twoSum(new int[]{2, 7, 11, 15}, 9))
            System.out.println(i);
    }
}

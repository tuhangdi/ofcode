package leetcode.Array;

/**
 * Created by thd on 2017/7/24
 *Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.
 *
 *
 *
 * 思路：Moore's voting算法 由于重复频率超过 floor(n/2)的数字只有一个，等价于与其余数字出现频率的差大于零。
 * 当遍历整个数组时，使用变量candidate记录当前重复次数最多的数，count计算candidate重复多余的次数。
 */
public class n169MajorityElement {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0)
                candidate = nums[i];
            if (candidate == nums[i])
                count++;
            else
                count--;
        }
        return candidate;
    }
}

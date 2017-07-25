package leetcode.Array;

/**
 * Created by thd on 2017/7/25
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 给定包含n + 1个整数的数组num，其中每个整数在1和n（含）之间，证明至少有一个重复的数字必须存在。 假设只有一个重复的数字，找到重复的一个。
 Note:
 You must not modify the array (assume the array is read only).
 You must use only constant, O(1) extra space.
 Your runtime complexity should be less than O(n2).
 There is only one duplicate number in the array, but it could be repeated more than once.

快慢指针找环起点(n142)
 */
public class n287FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,3};
        n287FindTheDuplicateNumber n = new n287FindTheDuplicateNumber();
        System.out.println(n.findDuplicate(nums));
    }
}

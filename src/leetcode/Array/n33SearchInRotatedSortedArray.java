package leetcode.Array;

/**
 * Created by thd on 2017/8/16
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 假设以升序排列的数组在您预先知道的枢轴上旋转。
 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.
 您将获得一个目标值进行搜索。 如果在数组中找到返回其索引，否则返回-1。
 You may assume no duplicate exists in the array.


 二分查找， 必然有一半是有序的

 */
public class n33SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) return mid;

            if (nums[lo] <= nums[mid]) { //左边有序
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return nums[lo] == target ? lo : -1;
    }
}

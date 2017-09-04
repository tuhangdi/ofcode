package leetcode.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by thd on 2017/9/4
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 您将获得一个整数数组nums，您必须返回一个新的计数数组。 计数数组具有count [i]是nums [i]右边较小元素的数量的属性。
 Example:

 Given nums = [5, 2, 6, 1]

 To the right of 5 there are 2 smaller elements (2 and 1).
 To the right of 2 there is only 1 smaller element (1).
 To the right of 6 there is 1 smaller element (1).
 To the right of 1 there is 0 smaller element.
 Return the array [2, 1, 1, 0].



 从尾到头，维护一个已排序的数组数组。 使用findIndex（）来查找排序数组中大于或等于目标数的第一个元素。
 例如，[5,2,3,6,1]，当我们达到2时，我们有一个排序的数组[1,3,6]，findIndex（）返回1，这是应该插入2的索引，它也是小于2的数字。
 然后我们将2插入排序的数组以形成[1,2,3,6]。


 */
public class n315CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        List<Integer> sorted = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = findIndex(sorted, nums[i]);
            ans[i] = index;
            sorted.add(index, nums[i]);
        }
        return Arrays.asList(ans);
    }

    private int findIndex(List<Integer> sorted, int target) {
        if (sorted.size() == 0) return 0;
        int start = 0;
        int end = sorted.size() - 1;
        if (sorted.get(end) < target) return end + 1;
        if (sorted.get(start) >= target) return 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (sorted.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (sorted.get(start) >= target) return start;
        return end;
    }
}

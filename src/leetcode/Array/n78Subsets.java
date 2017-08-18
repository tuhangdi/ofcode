package leetcode.Array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thd on 2017/8/18
 *
 *
 Given a set of distinct integers, nums, return all possible subsets.
 给定一组不同的整数nums，返回所有可能的子集。
 Note: The solution set must not contain duplicate subsets.
 注意：解决方案集不能包含重复的子集。
 For example,
 If nums = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]
 *
 */
public class n78Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, ArrayList<Integer> tempList, int[] nums, int j) {

        res.add(new ArrayList<>(tempList));

        for (int i = j; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(res, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        for (List l : subsets(nums)) {
            for (Object i : l) {
                System.out.print(i);
            }
            System.out.println("");
        }
    }
}

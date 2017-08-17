package leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by thd on 2017/8/17
 *
 *
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 给定一组候选数（C）（无重复）和目标数（T），找出C中所有独特的组合相加和为T。
 The same repeated number may be chosen from C unlimited number of times.
 可以从C无限次次中选择相同的重复次数。
 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
 [7],
 [2, 2, 3]
 ]


 */
public class n39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (candidates.length == 0) return list;
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    public void backtrack (List<List<Integer>> list, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                backtrack(list, tempList, candidates, remain - candidates[i], i); //不是i + 1 ，因为可以重复元素
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

package leetcode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thd on 2017/6/19.
 * A zero-indexed array A consisting of N different integers is given. The array contains all integers in the range [0, N - 1].
 给出了由N个不同整数组成的零索引数组A. 该数组包含[0，N-1]范围内的所有整数。
 Sets S[K] for 0 <= K < N are defined as follows:
 0 <= K <N的S [K]定义如下：
 S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }.

 Sets S[K] are finite for each K and should NOT contain duplicates.
 集合S [K]对于每个K是有限的，不应包含重复项。
 Write a function that given an array A consisting of N integers, return the size of the largest set S[K] for this array.
 写一个给定由N个整数组成的数组A的函数，返回该数组的最大集合S [K]的大小。

 Input: A = [5,4,0,3,1,6,2]
 Output: 4
 Explanation:
 A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

 One of the longest S[K]:
 S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}


 5 6 2 0这四个数字无论是从0开始还是从2开始，始终是这四个数字为一个集合,可做标记

 */
public class n565ArrayNesting {
    public int arrayNesting(int[] nums) {
        int max = 0;

        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {//从多个起点到达同一个值之后的路径都是完全相同的，所以每个值最多遍历一次.O(n)
            if (nums[i] < 0) continue;
            int tmp = nums[i];
            int res = 1;
            while (Math.abs(tmp) != i){
                res ++;
                tmp = nums[Math.abs(tmp)];
                nums[Math.abs(tmp)] *= -1;
            }

            max = Math.max(max, res);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,0,3,1,6,2};
        n565ArrayNesting n = new n565ArrayNesting();
        System.out.println(n.arrayNesting(nums));
    }
}

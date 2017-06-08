package leetcode.DP;

/**
 * Created by thd on 2017/6/8.
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * 给出一个非负整数的列表，a1，a2，...，an和目标S，现在有2个符号+和 - 。 对于每个整数，您应该从+和 - 中选择一个作为其新符号。
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 * 找出有多少种方式来分配符号来使整数等于目标值S.
 * <p>
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * <p>
 * The length of the given array is positive and will not exceed 20.
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
public class n494TargetSum {
    private int res = 0;

    public int findTargetSumWays(int[] nums, int S) {

        dfs(0, 0, nums, S);
        return res;

    }

    //Depth-first Search
    private void dfs(int sum, int n, int[] nums, int S) {
        if (n == nums.length) {
            if (sum == S) res++;
            return;
        }
        dfs(sum + nums[n], n + 1, nums, S);
        dfs(sum - nums[n], n + 1, nums, S);
    }

    //Dynamic Programming

    /**
     * sum（正） - sum（负） = target
     * <p>
     * 两边都加上同样的sum（正） + sum（负）：
     * <p>
     * sum（正） + sum（负） + sum（正） - sum（负） = target + sum（正） + sum（负）
     * <p>
     * 化简得：
     * <p>
     * 2 * sum（正） = target + sum（正） + sum（负） = target + sum（数组总和）
     * 对于每个元素，我们看看他与正数和只差是多少，
     * 这个结果处有没有其余的元素，没有我们就减一看看有没有其他元素，没有继续减一，直到见到0，这时候其实就是它自己了。
     * 对下一个元素依然这样判断。
     * 我们用一个标记来记录从0到正数和之间每个数当前用别的元素相加后能得到的个数，
     * 最后遍历完所有元素后，看看正数和记录了多少种其余元素相加得到的次数，就是我们要的方法数了。
     */
    private int dp(int[] nums, int S) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum < S || (sum + S)%2 == 1) return 0;// (sum + S)%2 == 1 ，无论如何2 *sum（正）都不可能是奇数
        int target = (S + sum) >> 1;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = target; i >= n; i--) {
                dp[i] += dp[i - n];
            }
        }
        return dp[target];
    }


    public static void main(String[] args) {
        int[] nums = {7,9,3,8,0,2,4,8,3,9};
        int S = 0;
        n494TargetSum n = new n494TargetSum();
        System.out.println(n.findTargetSumWays(nums, S));
        System.out.println("dp:" + n.dp(nums, S));
    }
}

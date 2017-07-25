package leetcode.DP;

/**
 * Created by thd on 2017/7/25
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 你是一个专业的强盗，计划在街上抢房。
 每个房子都有一定数量的钱，
 唯一的限制是阻止你们抢劫每一个房屋，相邻的房屋有安全系统连接，
 如果两个相邻的房屋在同一天晚上被打破，它会自动联系警察。

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 给出一个代表每个房子的非负整数的列表，确定你今天晚上可以抢救的最大金额，而不用警报。

 */
public class n198HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        else if (nums.length == 2) return Math.max(nums[0],nums[1]);
        else if (nums.length == 3) return Math.max(nums[0] + nums[2], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];
        int res = Math.max(nums[0] + nums[2], nums[1]);
        for (int i = 3; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], nums[i] + dp[i - 3]);
            if (dp[i] > res)
                res = dp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,7,9,3,1};
        n198HouseRobber n = new n198HouseRobber();
        System.out.println(n.rob(nums));
    }
}

package leetcode.DP;

/**
 * Created by thd on 2017/6/5.
 * Given an array of scores that are non-negative integers.
 * <p>
 * Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on.
 * Each time a player picks a number, that number will not be available for the next player.
 * This continues until all the scores have been chosen. The player with the maximum score wins.
 * 给出一组非负整数的分数。 玩家1从数组的任一端取一个数，然后玩家2选择一个数字，然后。。。
 * 每次玩家选择一个号码时，该号码将不会用于下一个玩家。
 * 这一直持续到所有的成绩都被选中。 具有最高分数的玩家获胜。
 * Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.
 * 给出一系列分数，预测玩家1是否是赢家。 你可以假设每次每个玩家都会拿以最大化他的得分。
 * <p>
 * Example 1:
 * Input: [1, 5, 2]
 * Output: False
 * Explanation: Initially, player 1 can choose between 1 and 2.
 * If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2).
 * So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
 * Hence, player 1 will never be the winner and you need to return False.
 * <p>
 * <p>
 * Example 2:
 * Input: [1, 5, 233, 7]
 * Output: True
 * Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
 * Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
 * 两人依次拿，如果P1赢，则P1拿的>P2拿的。我们把P1拿的视为“+”，把P2拿的视为“-”，如果最后结果大于等于0则P1赢。
 * 很特别的dp：建立dp[len][len]数组，dp[i][j]表示nums数组中i～j下标间player1能够获得的分数 - player2能够获得的分数
 */
public class n486PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        int [][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i+1; j < nums.length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }

    public static void main(String[] args) {
        n486PredictTheWinner n = new n486PredictTheWinner();
        int [] num = {1, 5, 233, 7};
        System.out.println(n.PredictTheWinner(num));

    }
}

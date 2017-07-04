package leetcode.String;

/**
 * Created by thd on 2017/7/1.
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same,
 * 使用最少次数使得两个string相同，每步可以删除一个元素
 *  where in each step you can delete one character in either string.
 *
 * Example 1:
 Input: "sea", "eat"
 Output: 2
 Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".

 dp，类似于编辑距离
 */
public class n583DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < word2.length() + 1; j++) {
            dp[0][j] = j;
        }
        int d;
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    d = 0;
                else
                    d = 2;
                int temp = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                dp[i][j] = Math.min(dp[i - 1][j - 1]+d, temp);
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        n583DeleteOperationForTwoStrings n = new n583DeleteOperationForTwoStrings();
        System.out.println(n.minDistance("", ""));
    }
}

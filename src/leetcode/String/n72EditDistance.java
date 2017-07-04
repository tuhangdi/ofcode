package leetcode.String;

/**
 * Created by thd on 2017/7/4.
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
 * (each operation is counted as 1 step.)
 给定两个单词word1和word2，找到将word1转换为word2所需的最少步骤数。 （每个操作计为1步）
 You have the following 3 operations permitted on a word:

 a) Insert a character
 b) Delete a character
 c) Replace a character


 思路：编辑距离，dp
 */


public class n72EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 2];
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < word2.length() + 1; i++) {
            dp[0][i] = i;
        }
        int d;
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    d = 0;
                else
                    d = 1;
                int temp = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                dp[i][j] = Math.min(temp, dp[i - 1][j - 1] + d);
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        n72EditDistance n = new n72EditDistance();
        System.out.println(n.minDistance("sea", "eaa"));
    }
}

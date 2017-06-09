package leetcode.DP;

/**
 * Created by thd on 2017/6/9.
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
 * 给定一个字符串s，找到最长的回文子序列长度。 您可以假设s的最大长度为1000。
 * Example 1:
 * Input:
 *
 * "bbbab"
 * Output:
 * 4
 * One possible longest palindromic subsequence is "bbbb".
 * Example 2:
 * Input:
 *
 * "cbbd"
 * Output:
 * 2
 * One possible longest palindromic subsequence is "bb".
 *
 *
 * 注意：最长回文子串必须是连续的，这里的最长回文子序列，可以是不连续的。
 * 首先i指针从尾到头遍历，j指针从i指针后面一个元素开始一直遍历到尾部～
 * 一开始dp[i][i]的值都为1，如果当前i和j所指元素相等，说明能够加到i～j的回文子串的长度中，所以更新dp[i][j] = dp[i+1][j-1] + 2;
 * 如果当前元素不相等，那么说明这两个i、j所指元素对回文串无贡献，则dp[i][j]就是从dp[i+1][j]和dp[i][j-1]中选取较大的一个值即可。
 */
public class n516LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        char[] ss = s.toCharArray();
        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < s.length(); j++) {
                if (ss[i] == ss[j])
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][s.length()-1];
    }

    public static void main(String[] args) {
        String s= "bbbab";
        n516LongestPalindromicSubsequence n = new n516LongestPalindromicSubsequence();
        System.out.println(n.longestPalindromeSubseq(s));
    }
}

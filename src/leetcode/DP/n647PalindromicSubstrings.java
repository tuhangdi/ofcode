package leetcode.DP;

/**
 * Created by thd on 2017/9/4
 * Given a string, your task is to count how many palindromic substrings in this string.
 给定一个字符串，你的任务是计算这个字符串中有多少个回文子字符串。
 The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 具有不同起始索引或结束索引的子字符串被计为不同的子字符串，即使它们由相同的字符组成。
 Example 1:
 Input: "abc"
 Output: 3
 Explanation: Three palindromic strings: "a", "b", "c".
 Example 2:
 Input: "aaa"
 Output: 6
 Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".


 中心两边扩展，奇偶分开
 */
public class n647PalindromicSubstrings {

    int count = 0;

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        return count;
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}

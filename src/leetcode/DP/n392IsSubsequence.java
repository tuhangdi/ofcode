package leetcode.DP;

/**
 * Created by thd on 2017/6/5.
 * Given a string s and a string t, check if s is subsequence of t.
 给定一个字符串s和一个字符串t，检查是否是t的子序列。
 You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 您可以假设在s和t中只有小写的英文字母。 t可能是一个非常长（长度= 500,000）的字符串，s是一个短字符串（<= 100）。
 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 字符串的子序列是由原始字符串形成的新字符串，通过删除一些（可以不是）字符而不干扰其余字符的相对位置。 （即，“ace”是“abcde”的子序列，而“aec”不是）。
 Example 1:
 s = "abc", t = "ahbgdc"

 Return true.

 Example 2:
 s = "axc", t = "ahbgdc"

 Return false.



i.j遍历字符串s和t，然后如果字符相等，则i和j自增1，反之只有j自增1，最后看i是否等于s的长度，等于说明s已经遍历完了，而且字符都有在t中出现过
 */
public class n392IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        int i = 0,j =0;
        while(i < chs.length && j < cht.length){
            if(chs[i] == cht[j]) i++;
            j++;
        }
        return i == chs.length;
    }

    public static void main(String[] args) {
     String   s = "abc", t = "ahbgdc";
     n392IsSubsequence n = new n392IsSubsequence();
        System.out.println(n.isSubsequence(s,t));
    }
}

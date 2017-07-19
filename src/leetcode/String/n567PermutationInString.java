package leetcode.String;

import java.util.Arrays;

/**
 * Created by thd on 2017/7/18.
 *
 Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 给定两个字符串s1和s2，如果s2包含s1的置换，则写入一个函数返回true。 换句话说，第一个字符串的排列之一是第二个字符串的子串。

 Example 1:
 Input:s1 = "ab" s2 = "eidbaooo"
 Output:True
 Explanation: s2 contains one permutation of s1 ("ba").
 Example 2:
 Input:s1= "ab" s2 = "eidboaoo"
 Output: False
 Note:
 The input strings only contain lower case letters.
 The length of both given strings is in range [1, 10,000].

 滑动窗口，窗口为s1的大小，如果s2中有所有元素与s1相同的窗口，则返回true。
 */
public class n567PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            map1[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            map2[s2.charAt(i) - 'a']++;
            if (i > s1.length())
                map2[s2.charAt(i - s1.length()) - 'a']--;//向右滑动删除第1个元素
            if (Arrays.equals(map1, map2))
                return true;
        }
        return false;
    }
}

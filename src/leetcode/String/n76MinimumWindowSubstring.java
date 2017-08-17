package leetcode.String;

/**
 * Created by thd on 2017/8/17
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 给定字符串S和字符串T，找到S中的最小窗口，其中将包含T中的所有字符。复杂度O（n）
 For example,
 S = "ADOBECODEBANC"
 T = "ABC"
 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T, return the empty string "".
 如果S中没有覆盖T中所有字符的窗口，返回空字符串“”。
 If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 如果有多个这样的窗口，您可以确保在S中始终只有一个唯一的最小窗口。

 */
public class n76MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty()) return "";
        int i = 0, j = 0;
        int[] tMap = new int[128];
        int[] sMap = new int[128];
        for (int k = 0; k < t.length(); k++) {
            tMap[t.charAt(k)]++;
        }
        int found = 0;//标记已找到的t元素个数
        int len = Integer.MAX_VALUE;
        String res = "";
        while (j < s.length()) {
            if (found < t.length()) {
                if (tMap[s.charAt(j)] > 0) {
                    sMap[s.charAt(j)]++;
                    if (sMap[s.charAt(j)] <= tMap[s.charAt(j)]) {
                        found++;
                    }
                }
                j++;
            }
            while (found == t.length()) {
                if (j - i < len) {
                    len = j - i;
                    res = s.substring(i, j); //保存结果
                }
                if (tMap[s.charAt(i)] > 0) {//从头开始删元素，看是否能缩小窗口
                    sMap[s.charAt(i)]--;
                    if (sMap[s.charAt(i)] < tMap[s.charAt(i)]) {
                        found--;
                    }
                }
                i++;
            }
        }
        return res;
    }
}

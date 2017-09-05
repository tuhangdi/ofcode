package leetcode.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by thd on 2017/9/5
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

 Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

 The order of output does not matter.

 Example 1:

 Input:
 s: "cbaebabacd" p: "abc"

 Output:
 [0, 6]

 Explanation:
 The substring with start index = 0 is "cba", which is an anagram of "abc".
 The substring with start index = 6 is "bac", which is an anagram of "abc".
 Example 2:

 Input:
 s: "abab" p: "ab"

 Output:
 [0, 1, 2]

 Explanation:
 The substring with start index = 0 is "ab", which is an anagram of "ab".
 The substring with start index = 1 is "ba", which is an anagram of "ab".
 The substring with start index = 2 is "ab", which is an anagram of "ab".

 */

public class n438FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] ss = new int[26];
        int[] pp = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pp[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            ss[s.charAt(i) - 'a']++;
            if (i >= p.length())
                ss[s.charAt(i - p.length()) - 'a']--;
            if (Arrays.equals(pp, ss))
                res.add(i - p.length() + 1);
        }
        return res;
    }
}

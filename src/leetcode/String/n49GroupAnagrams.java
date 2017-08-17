package leetcode.String;

import java.util.*;

/**
 * Created by thd on 2017/8/17
 *
 * Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]

 */
public class n49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0 || strs == null) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String ss = String.valueOf(ch);
            if (!map.containsKey(ss))
                map.put(ss, new ArrayList<String>());
            map.get(ss).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

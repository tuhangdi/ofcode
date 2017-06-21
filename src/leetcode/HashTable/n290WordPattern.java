package leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by thd on 2017/6/21.
 * Given a pattern and a string str, find if str follows the same pattern.
 给定一个模式和一个字符串str，找到如果str遵循相同的模式。

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.


 Examples:
 pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.

 "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd"
 "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t"

 */
public class n290WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || pattern == null) return false;
        Map m = new HashMap();
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) return false;
        char[] p = pattern.toCharArray();
        for (int i = 0; i < p.length; i++) {
            if (!Objects.equals(m.put(p[i], i), m.put(strs[i], i)))//map.put()，如果第二次put进同样的key不同value，返回的值是被挤掉的那个value！不然就是null。不能用!= 比较，否在在超过127个元素后就会出错
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        n290WordPattern n = new n290WordPattern();
        System.out.println(n.wordPattern("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd",  "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t"
        ));
    }
}

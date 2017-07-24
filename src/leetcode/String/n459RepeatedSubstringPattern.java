package leetcode.String;

/**
 * Created by thd on 2017/7/20.
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 给定一个非空字符串，检查它是否可以通过获取一个子字符串并将子字符串的多个副本附加在一起来构造。 您可以假定给定的字符串仅由小写的英文字母组成，其长度不会超过10000。
 Example 1:
 Input: "abab"

 Output: True

 Explanation: It's the substring "ab" twice.
 Example 2:
 Input: "aba"

 Output: False
 Example 3:
 Input: "abcabcabcabc"

 Output: True

 Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)


 如果字符串S重复块,则可用S = SpSp（例如，S最多有两个可重复的块）
 如果我们重复字符串，那么SS=SpSpSpSp。
 通过删除每个字符来销毁第一个和最后一个模式，我们生成一个新的S2=SxSpSpSy。

 如果字符串里面有可重复的模式，S2应该S在其字符串中有效。
 */
public class n459RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        //System.out.println(str.substring(1,str.length() - 1));
        return str.substring(1, str.length() - 1).contains(s);
    }

    public static void main(String[] args) {
        n459RepeatedSubstringPattern n = new n459RepeatedSubstringPattern();
        System.out.println(n.repeatedSubstringPattern("abab"));
    }
}

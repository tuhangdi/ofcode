package leetcode.String;

/**
 * Created by thd on 2017/6/29.
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 给定一个任意的赎金票据字符串和另一个包含所有杂志的字母的字符串，写一个函数，如果可以从杂志中构建赎金票据，则返回true; 否则会返回false。
 Each letter in the magazine string can only be used once in your ransom note.
 杂志字符串中的每个字母只能在您的赎金笔记中使用一次。

 canConstruct("a", "b") -> false
 canConstruct("aa", "ab") -> false
 canConstruct("aa", "aab") -> true


 */
public class n383RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ab =new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            ab[magazine.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (ab[ransomNote.charAt(i) - 'a'] > 0)
                ab[ransomNote.charAt(i) - 'a'] --;
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        n383RansomNote n = new n383RansomNote();
        System.out.println(n.canConstruct("aa", "ab"));
    }
}

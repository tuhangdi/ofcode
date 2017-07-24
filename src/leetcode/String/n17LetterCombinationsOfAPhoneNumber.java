package leetcode.String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thd on 2017/7/21.
 * Given a digit string, return all possible letter combinations that the number could represent.
 给定一个数字字符串，返回数字可能代表的所有可能的字母组合。
 A mapping of digit to letters (just like on the telephone buttons) is given below.



 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class n17LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        String[] table = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<>();
        leeterCombination(list, digits, "", 0, table);
        return list;
    }
    private void leeterCombination(List<String> list, String digits, String curr, int index, String[] table){
        if (index == digits.length()) {
            if (curr.length() != 0) list.add(curr);
            return;
        }

        String temp = table[digits.charAt(index) - '0'];
        for (int i = 0; i < temp.length(); i++) {
            String next = curr + temp.charAt(i);
            leeterCombination(list, digits, next, index + 1, table);
        }
    }

    public static void main(String[] args) {
        n17LetterCombinationsOfAPhoneNumber n = new n17LetterCombinationsOfAPhoneNumber();
        for (String s : n.letterCombinations("234"))
            System.out.println(s);
    }
}

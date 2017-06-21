package leetcode.HashTable;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by thd on 2017/6/21.
 *
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 * 给出一个单词列表，返回可以使用同一行字母键打出的单词。
 *
 * Example 1:
 Input: ["Hello", "Alaska", "Dad", "Peace"]
 Output: ["Alaska", "Dad"]
 */
public class n500KeyboardRow {
    public String[] findWords(String[] words) {
        List<String> l = new ArrayList<>();
        String regex = "(?i)[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*";
        for (int i = 0; i < words.length; i++) {
            if (Pattern.matches(regex, words[i])) l.add(words[i]);
        }
        String[] s = new String[l.size()];
        for (int i = 0; i < s.length; i++) {
            s[i] = l.get(i);
            System.out.println(s[i]);
        }
        return s;
    }

    public static void main(String[] args) {
        String[] s = {"Hello", "Alaska", "Dad", "Peace"};
        n500KeyboardRow n = new n500KeyboardRow();
        n.findWords(s);
    }
}

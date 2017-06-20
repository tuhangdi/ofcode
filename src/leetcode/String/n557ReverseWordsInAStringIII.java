package leetcode.String;

/**
 * Created by thd on 2017/6/20.
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 给定一个字符串，你需要颠倒一个句子中每个单词中的字符顺序，同时保留空格和初始单词顺序。
 Example 1:
 Input: "Let's take LeetCode contest"
 Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class n557ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            if (ch[i] == ' ') {
                end = i - 1;
                reverseI(ch, start, end);
                start = i + 1;
            }
        }
        reverseI(ch, start, s.length() - 1);
        return new String(ch);
    }
    public char[] reverseI(char[] ch, int start, int end){
        while(start < end){
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
        return ch;
    }

    public static void main(String[] args) {
        n557ReverseWordsInAStringIII n = new n557ReverseWordsInAStringIII();
        System.out.println(n.reverseWords("Let's take LeetCode contest"));
    }
}

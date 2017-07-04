package leetcode.String;

/**
 * Created by thd on 2017/7/1.
 * Write a function that takes a string as input and reverse only the vowels of a string.
 编写一个函数，它以字符串作为输入，只反转字符串的元音。
 Example 1:
 Given s = "hello", return "holle".

 Example 2:
 Given s = "leetcode", return "leotcede".

 Note:
 The vowels does not include the letter "y".
 */
public class n345ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        int first = 0, end = s.length() - 1;
        if (s.length() == 0 || s.length() == 1) return s;
        char[] ch = s.toCharArray();
        String y = "aeiouAEIOU";
        while (first < end) {
            while (first < end && !y.contains(ch[first] + ""))
                first ++;
            while (first < end && !y.contains(ch[end] + ""))
                end --;
            char temp = ch[first];
            ch[first] = ch[end];
            ch[end] = temp;
            first ++;
            end --;
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        n345ReverseVowelsOfAString n = new n345ReverseVowelsOfAString();
        System.out.println(n.reverseVowels("OE"));
    }
}

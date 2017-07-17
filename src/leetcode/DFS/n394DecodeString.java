package leetcode.DFS;

import java.util.Stack;

/**
 * Created by thd on 2017/7/17.
 * Given an encoded string, return it's decoded string.
 给定一个编码的字符串，返回它的解码字符串。
 The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

 You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

 Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 Examples:

 s = "3[a]2[bc]", return "aaabcbc".
 s = "3[a2[c]]", return "accaccacc".
 s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class n394DecodeString {
    public String decodeString(String s) {
        char[] ch = s.toCharArray();
        Stack<Integer> num = new Stack<>();
        Stack<String> res = new Stack<>();
        res.push("");
        int i = 0;
        while (i < ch.length) {
            if (ch[i] >= '0' && ch[i] <= '9') {
                int temp = 0;
                while (ch[i] >= '0' && ch[i] <= '9') {
                    temp = temp * 10 +  (ch[i] - '0');
                    i++;
                }
                i--;
                num.push(temp);
            } else if (ch[i] == '[') {
                res.push("");
            } else if (ch[i] == ']') {
                String temps = new String(res.pop());
                StringBuilder sb = new StringBuilder();
                int j = num.pop();
                while (j > 0) {
                    sb.append(temps);
                    j--;
                }
                res.push(res.pop() + sb.toString());
            } else {
                res.push(res.pop() + ch[i]);
            }
            i++;
        }
        return res.pop();
    }

    public static void main(String[] args) {
        n394DecodeString n = new n394DecodeString();
        System.out.println(n.decodeString("2[abc]3[cd]ef"));
    }
}


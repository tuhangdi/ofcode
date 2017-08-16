package leetcode.DP;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * Created by thd on 2017/8/16
 *
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 给定一个仅包含字符'（'和'）'的字符串，找到最长有效（正确的）括号子字符串的长度。
 For "(()", the longest valid parentheses substring is "()", which has length = 2.
 对于“（（）”，最长有效的括号子字符串为“（）”，其长度为2。
 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 另一个例子是“）（）（））”，其中最长有效括号子串是“（）（）”，其长度= 4。

 */
public class n32LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                if (stack.isEmpty()) left = i;
                else {
                    stack.pop();
                    if (stack.isEmpty()) max = Math.max(max, i - left);
                    else max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    @Test
    public void test() {
        String s = "((()()))))";
        System.out.println(longestValidParentheses(s));
    }
}

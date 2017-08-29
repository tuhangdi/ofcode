package leetcode.DFS;

import java.util.*;

/**
 * Created by thd on 2017/8/29
 *
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 删除无效括号的最小数量，以使输入字符串有效。 返回所有可能的结果。
 Note: The input string may contain letters other than the parentheses ( and ).
 注意：输入字符串可能包含除（、）之外的字母。
 Examples:
 "()())()" -> ["()()()", "(())()"]
 "(a)())()" -> ["(a)()()", "(a())()"]
 ")(" -> [""]

 */
public class n301RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) { //bfs
        List<String> res = new ArrayList<>();

        if (s == null) return res;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            s = queue.poll();

            if (isValid(s)) {//找到一个答案
                res.add(s);
                found = true;
            }

            if (found) continue;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;

                String t = s.substring(0, i) + s.substring(i + 1);

                if (!visited.contains(t)) {
                    queue.add(t);
                    visited.add(t);
                }
            }
        }
        return res;
    }

    private boolean isValid(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')' && count-- == 0) return false;
        }

        return (count == 0);
    }
}

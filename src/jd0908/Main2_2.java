package jd0908;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by thd on 2017/9/8
 */
public class Main2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(solve(s));
    }

    private static int solve(String str) {
        if ("".equals(str)) return 1;
        int x = str.indexOf("(");
        String temp = str.substring(0, x) + str.substring(x + 1);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < temp.length(); i++) {
            char c = temp.charAt(i);
            if (c == ')') {
                String s = temp.substring(0, i) + temp.substring(i + 1);
                if (isVaild(s)) {
                    if (map.containsKey(s)) map.put(s, map.get(s) + 1);
                    else map.put(s, 1);
                }
            }
        }
        int cnt = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            cnt += solve(e.getKey()) * e.getValue();
        }
        return cnt;
    }

    private static boolean isVaild(String str) {
        int m = 0 , n = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') m++;
            else if (str.charAt(i) == ')') n++;
            if (n > m) return false;
        }
        return m == n;
    }
}

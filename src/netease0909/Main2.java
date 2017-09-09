package netease0909;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by thd on 2017/9/9
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<String> sl = new ArrayList<>();
        sl = generateParenthesis(s.length() / 2);
        System.out.println(sl.size());
        int max = Integer.MIN_VALUE;
        int res = 0;
        int i = 0;
        for (String t : sl) {
            int n = getLongestCommonSubsequence(s, t);
            if (max <= n) {
                max = n;
                i++;
                if (i > res)
                    res = i;
            } else i = 0;

        }
        System.out.println(res);

    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public static void backtrack(List<String> list, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }

        if (open < max)
            backtrack(list, str + "(", open + 1, close, max);
        if (close < open)
            backtrack(list, str + ")", open, close + 1, max);
    }

    public static int getLongestCommonSubsequence(String a, String b) { //https://www.programcreek.com/2014/04/longest-common-subsequence-java/
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }


}

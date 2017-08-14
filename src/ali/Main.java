package ali;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    public static int  count (int N,int P,int M, int T ) {
        long[][] dp = new long[N+10][M+10];
        dp[P][0] = 1;
        for (int j = 1; j <= M; j++) {
            for (int i = 1; i <= N; i++) {
                if ((i-1) >= 1)
                    dp[i][j] += dp[i - 1][j - 1];
                if ((i+1) <= N)
                    dp[i][j] += dp[i + 1][j - 1];
            }
        }
        return (int)dp[T][M];
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long res;
        int n= Integer.parseInt(in.nextLine().trim());
        int p= Integer.parseInt(in.nextLine().trim());
        int m= Integer.parseInt(in.nextLine().trim());
        int t= Integer.parseInt(in.nextLine().trim());
        res = count(n, p, m, t);
        System.out.println(String.valueOf(res));

    }
}
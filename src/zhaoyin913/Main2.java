package zhaoyin913;

import java.util.Scanner;

/**
 * Created by thd on 2017/9/13
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] num = new int[m];
        for (int i = 0; i < m; i++) {
            num[i] = sc.nextInt();
        }
        int[] dp = new int[m];
        int presum = 0;
        for (int i = m - 1; i >= 0; i--) {
            presum += num[i];
            if (i + 1 == m || i + 2 == m)
                dp[i] = presum;
            else
                dp[i] = Math.max(presum - dp[i + 1], presum - dp[i + 2]);
        }
        if (dp[0] > presum - dp[0])
            System.out.println(true);
        else
            System.out.println(false);
    }
}

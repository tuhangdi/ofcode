package netease812;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by thd on 2017/8/12
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n + 1];
        int[] y = new int[n + 1];
        //int[][] d = new int[n + 1][n + 1];
        long[] res = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            x[i] = sc.nextInt();
        }
        for (int i = 1; i < n + 1; i++) {
            y[i] = sc.nextInt();
        }
//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 1; j < n + 1; j++) {
//                d[i][j] = Math.abs((y[j] - y[i])) + Math.abs((x[j] - x[i]));
//            }
//        }
        for (int i = 1; i < n + 1; i++) {
            res[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < n + 1; i++) {
            long num = 0;
            //int[] nums = new int[n + 1];

            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    // nums[k] = d[k][j];
                    int[] distance = new int[n + 1];
                    for (int l = 1; l < n + 1; l++) {
                        distance[l] = Math.abs((y[l] - y[k])) + Math.abs((x[l] - x[j]));
                    }
                    Arrays.sort(distance);
                    num = 0;
                    for (int m = 1; m < i + 1; m++) {
                        num += distance[m];
                    }
                    res[i] = Math.min(res[i], num);
                }
            }
        }

        for (int i = 1; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println(res[n]);

    }

}

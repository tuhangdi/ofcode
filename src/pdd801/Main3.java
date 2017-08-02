package pdd801;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by thd on 2017/8/1
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] w = new int[m];
        for (int i = 0; i < m; i++) {
            w[i] = sc.nextInt();
        }
        Arrays.sort(h);
        Arrays.sort(w);
        int res = 0;
        int j = 0;
        for (int i = 0; i < h.length; i++) {
            if (w[j++] >= h[i]) {
                res++;
            }
            else
                i--;
            if (j == w.length) break;
        }
        System.out.println(res);
    }
}

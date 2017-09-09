package netease0909;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by thd on 2017/9/9
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] res = new String[t];
        Arrays.fill(res, "No");
        for (int i = 0; i < t; i++) {
            int d2= 0, d4 = 0;
            int n = sc.nextInt();
            int[] num = new int[n];
            for (int j = 0; j < n; j++) {
                num[j] = sc.nextInt();
            }

            for (int j = 0; j < n; j++) {
                if(num[j] % 4==0) d4++;
                else if(num[j] > 2 && num[j] % 2==0) d2++;
                else ;
            }

            if((2 * d4 + d2) >= n)
                res[i] = "Yes";
        }
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}

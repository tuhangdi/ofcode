package nowcoder616;


import java.util.Scanner;

/**
 * Created by thd on 2017/6/16.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 0 || n == 1) System.out.println(n + 1);
        else {
            int [] num = new int[n];
            num[0] = 2;
            for (int i = 1; i < n; i++) {
                num[i] = num[i - 1] * 2 + i;
            }
            double f = (double)num[n -1] /Math.pow(2,n - 1);
            System.out.print(String.format("%.1f", f));
        }
    }
}

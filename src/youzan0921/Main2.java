package youzan0921;

import java.util.Scanner;

/**
 * Created by thd on 2017/9/21
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long k = sc.nextLong();
        long m = sc.nextLong();
        long n = sc.nextLong();
        for (long i = 0; i < m; i++) {
            for (long j = 0; j < n; j++) {

                if (k == sc.nextLong()) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
        System.out.println(-1 + " " + -1);
    }
}

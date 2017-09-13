package zhaoyin913;

import java.util.Scanner;

/**
 * Created by thd on 2017/9/13
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long n = sc.nextLong();
        long mul = commonMultiple(a, b);
        System.out.println(n/mul);
    }

    public static long commonDivisor(long n, long m) {
        while (n % m != 0) {
            long temp = n % m;
            n = m;
            m = temp;
        }
        return m;
    }

    public static long commonMultiple(long n, long m) {
        return n * m / commonDivisor(n, m);
    }
}

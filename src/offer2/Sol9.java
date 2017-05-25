package offer2;

/**
 * Created by thd on 2017/5/25.
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 */
public class Sol9 {
    public int Fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int[] f = new int[n];
        f[0] = f[1] = 1;
        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n-1];

    }

    public static void main(String[] args) {
        Sol9 s = new Sol9();
        System.out.println(s.Fibonacci(3));
    }
}

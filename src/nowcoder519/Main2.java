package nowcoder519;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by thd on 2017/5/19.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[3 * n];
        long sum = 0;
        int t = 0;
        for (int i = 0; i < 3 * n; i++) {
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);
        int i = num.length - 2;
        while (t < n) {
            sum += num[i];
            i = i - 2;
            t++;
        }
        System.out.println(sum);
    }
}

package nowcoder519;

import java.util.Scanner;

/**
 * Created by thd on 2017/5/19.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int t = 0;
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        int i = 0;
        while (i < n-1) {
            if ((num[i] > num[i + 1])) {

                i = checkpos(num, i);
                t++;
                i++;
            } else if (num[i] < num[i + 1]) {
                i = checkneg(num, i);
                t++;
                i++;
            }
            else {
                i = checkde(num,i);

                }
            if(i == n -1) {
                t++;
            }

        }
        System.out.println(t);
    }

    public static int checkpos(int[] num, int start) {
        if (num.length - 1 == start) return start;
        if (num[start] >= num[start + 1]) return checkpos(num, start + 1);

        return start;
    }

    public static int checkneg(int[] num, int start) {
        if (num.length - 1 == start) return start;
        if (num[start] <= num[start + 1]) return checkneg(num, start + 1);


        return start;
    }
    public static int checkde(int[] num, int start) {
        if (num.length - 1 == start) return start;
        if (num[start] == num[start + 1]) return checkde(num, start + 1);

        return start;
    }

}

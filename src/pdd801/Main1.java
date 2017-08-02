package pdd801;

import java.util.Scanner;

/**
 * Created by thd on 2017/8/1
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            long Max1 = 1;
            long Max2 = 1;
            long Max3 = 1;
            long Min1 = 1;
            long Min2 = 1;
            for (int i = 0; i < n; i++) {
                long num = scanner.nextLong();
                if (num > 0) {
                    if (num > Max1) {
                        Max3 = Max2;
                        Max2 = Max1;
                        Max1 = num;
                        continue;
                    } else if (num > Max2) {
                        Max3 = Max2;
                        Max2 = num;
                    } else if (num > Max3) {
                        Max3 = num;
                    }
                } else {
                    if (num < Min1) {
                        Min2 = Min1;
                        Min1 = num;
                    } else if (num < Min2) {
                        Min2 = num;
                    }
                }
            }
            if (Min1 != 1 || Min2 != 1) {
                if (Min1 * Min2 < Max2 * Max3) {
                    System.out.println(Max2 * Max3 * Max1);
                } else {
                    System.out.println(Min1 * Min2 * Max1);
                }
            } else {
                System.out.println(Max2 * Max3 * Max1);
            }
        }
    }
}

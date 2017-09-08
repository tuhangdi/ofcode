package jd0908;

import java.util.Scanner;

/**
 * Created by thd on 2017/9/8
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int temp = 1;
        int res = 0;
        while (temp < s.length()) {
            if (s.substring(0, temp).equals(s.substring(s.length() - temp, s.length()))) {

                res = temp;
            }
            temp++;
        }
        System.out.println(s+ s.substring(res, s.length()));
    }
}

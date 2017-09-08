package jd0908;

import java.util.Scanner;

/**
 * Created by thd on 2017/9/8
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int res = 1;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                temp++;
            } else {
                res *= temp;
                temp--;
            }

        }
        System.out.println(res);
    }
}

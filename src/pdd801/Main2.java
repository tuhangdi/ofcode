package pdd801;

import java.util.Scanner;

/**
 * Created by thd on 2017/8/1
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        int[] a = new int[s1.length()];
        int[] b = new int[s2.length()];
        int[] c = new int[s1.length() + s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            a[s1.length() - 1- i] = s1.charAt(i) - '0';
        }
        for (int i = 0; i < s2.length(); i++) {
            b[s2.length() - 1 - i] = s2.charAt(i) - '0';
        }

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                c[i+j]+=a[i]*b[j];
            }
        }
        for (int i = 0; i < c.length - 1; i++) {
            c[i+1]+=c[i]/10;
            c[i]=c[i]%10;
        }

        StringBuffer sb = new StringBuffer();
        boolean flag = true;
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] == 0 && flag) {
                continue;
            } else {
                flag = false;
            }
            sb.append(c[i]);
        }
        if (flag) System.out.println(0);
        else
            System.out.println(sb.toString());
    }
}

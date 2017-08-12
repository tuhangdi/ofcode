package netease812;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by thd on 2017/8/12
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s = sc.next();
        if (s == null) {
            System.out.println(0);
            return;
        }
        char[] ch = s.toCharArray();
        Set se = new HashSet();
        for (int i = 0; i < ch.length; i++) {
            se.add(ch[i]);
        }
        if (se.size() > 2)
            System.out.println(0);
        if (se.size() == 2)
            System.out.println(2);
        if (se.size() == 1)
            System.out.println(1);

    }
}

package xyk51;

import java.util.Scanner;

/**
 * Created by thd on 2017/9/18
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] ch = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'A');
            for (int j = 0; j < s.length(); j++) {
                if (ch[j] == c || ch[j] == (char)(c + 32))
                    sb.append(ch[j]);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (!(ch[i] >= 'A' && ch[i] <= 'Z' || ch[i] >= 'a' && ch[i] <= 'z'))
                sb.append(ch[i]);
        }
        System.out.println(sb);
    }
}

package nowcoder725;

import java.util.Scanner;

/**
 * Created by thd on 2017/7/26
 * [编程题] 偶串
 时间限制：1秒
 空间限制：32768K
 如果一个字符串由两个相同字符串连接而成,就称这个字符串是偶串。例如"xyzxyz"和"aaaaaa"是偶串,但是"ababab"和"xyzxy"却不是。
 牛牛现在给你一个只包含小写字母的偶串s,你可以从字符串s的末尾删除1和或者多个字符,保证删除之后的字符串还是一个偶串,牛牛想知道删除之后得到最长偶串长度是多少。
 输入描述:
 输入包括一个字符串s,字符串长度length(2 ≤ length ≤ 200),保证s是一个偶串且由小写字母构成


 输出描述:
 输出一个整数,表示删除之后能得到的最长偶串长度是多少。保证测试数据有非零解

 输入例子1:
 abaababaab

 输出例子1:
 6
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int i = s.length() - 2;
        while(i > 0) {
            String f = s.substring(0, i/2);
            String e = s.substring(i/2, i);
            if (f.equals(e)) {
                System.out.println(i);
                break;
            }
            i -= 2;
        }
    }
}

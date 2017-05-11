package hw;

import java.util.Scanner;

/**
 * Created by thd on 2017/4/17.
 * 题目描述
 写出一个程序，接受一个有字母和数字以及空格组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。

 输入描述:
 输入一个有字母和数字以及空格组成的字符串，和一个字符。


 输出描述:
 输出输入字符串中含有该字符的个数。

 输入例子:
 ABCDEF
 A

 输出例子:
 1
 */
public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            String s = sc.nextLine();
            char[] strs = str.toCharArray();
            char[] ch = s.toCharArray();
            int num = 0;
            for (int i = 0; i < str.length(); i++) {
                if (strs[i] == Character.toLowerCase(ch[0]) || strs[i] == Character.toUpperCase(ch[0]))
                    num++;
            }
            System.out.println(num);
        }
    }
}

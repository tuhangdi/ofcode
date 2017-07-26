package nowcoder725;

import java.util.Scanner;

/**
 * Created by thd on 2017/7/26
 * [编程题] DNA片段
 时间限制：1秒
 空间限制：32768K
 牛牛从生物科研工作者那里获得一段字符串数据s,牛牛需要帮助科研工作者从中找出最长的DNA序列。
 DNA序列指的是序列中只包括'A','T','C','G'。牛牛觉得这个问题太简单了,就把问题交给你来解决。
 例如: s = "ABCBOATER"中包含最长的DNA片段是"AT",所以最长的长度是2。
 输入描述:
 输入包括一个字符串s,字符串长度length(1 ≤ length ≤ 50),字符串中只包括大写字母('A'~'Z')。


 输出描述:
 输出一个整数,表示最长的DNA片段

 输入例子1:
 ABCBOATER

 输出例子1:
 2
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.next();
        int temp = 0;
        int res = 0;
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == 'A' || in.charAt(i) == 'T' || in.charAt(i) == 'C' || in.charAt(i) == 'G') {
                temp++;
                if (res < temp) res = temp;
            }
            else {
                temp = 0;
            }
        }
        System.out.println(res);
    }
}

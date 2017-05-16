package wangyi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by thd on 2017/5/16.
 * [编程题] 小易记单词
 * 时间限制：1秒
 * 空间限制：32768K
 * 小易参与了一个记单词的小游戏。
 * 游戏开始系统提供了m个不同的单词，小易记忆一段时间之后需要在纸上写出他记住的单词。
 * 小易一共写出了n个他能记住的单词，如果小易写出的单词是在系统提供的，将获得这个单词长度的平方的分数。
 * 注意小易写出的单词可能重复，但是对于每个正确的单词只能计分一次。
 * 输入描述:
 * 输入数据包括三行：
 * <p>
 * 第一行为两个整数n(1 ≤ n ≤ 50)和m(1 ≤ m ≤ 50)。以空格分隔
 * <p>
 * 第二行为n个字符串，表示小易能记住的单词，以空格分隔，每个单词的长度小于等于50。
 * <p>
 * 第三行为m个字符串，系统提供的单词，以空格分隔，每个单词的长度小于等于50。
 * <p>
 * <p>
 * 输出描述:
 * 输出一个整数表示小易能获得的分数
 * <p>
 * 输入例子:
3 4
apple orange strawberry
strawberry orange grapefruit watermelon
 * <p>
 * 输出例子:
 * 136
 */
public class Main10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s = sc.nextLine();
        String remb = sc.nextLine();
        String sum = sc.nextLine();
        int sumnum = 0;
        String[] rembs = remb.split(" ");
        String[] sums = sum.split(" ");
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rembs[i].equals(sums[j])) {
                    if(!set.contains(sums[j])) {
                        set.add(sums[j]);
                        sumnum += (sums[j].length() * sums[j].length());
                    }
                }
            }
        }
        System.out.println(sumnum);
    }
}

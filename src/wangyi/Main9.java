package wangyi;

import java.util.Scanner;

/**
 * Created by thd on 2017/5/16.
 * [编程题] 涂棋盘
 * 时间限制：1秒
 * 空间限制：32768K
 * 小易有一块n*n的棋盘，棋盘的每一个格子都为黑色或者白色，小易现在要用他喜欢的红色去涂画棋盘。
 * 小易会找出棋盘中某一列中拥有相同颜色的最大的区域去涂画，帮助小易算算他会涂画多少个棋格。
 * 输入描述:
 * 输入数据包括n+1行：
 * <p>
 * 第一行为一个整数n(1 ≤ n ≤ 50),即棋盘的大小
 * <p>
 * 接下来的n行每行一个字符串表示第i行棋盘的颜色，'W'表示白色，'B'表示黑色
 * <p>
 * 输出描述:
 * 输出小易会涂画的区域大小
 * <p>
 * 输入例子:
 * 3
 * BWW
 * BBB
 * BWB
 * <p>
 * 输出例子:
 * 3
 */

public class Main9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.nextLine();
        int max = 0;
        char[][] ch = new char[n][n];
        for (int i = 0; i < n; i++) {
            String ss = sc.nextLine();
            char[] temp = ss.toCharArray();
            for (int k = 0; k < n; k++) {
                ch[i][k] = temp[k];
            }
        }
        for (int i = 0; i < n; i++) {
            int maxin = 1;
            for (int j = 0; j < n - 1; j++) {
                if (ch[j][i] == ch[j + 1][i]) {
                    maxin++;
                }
                else {
                    max = Math.max(max, maxin);
                    maxin = 1;
                }
                max = Math.max(max, maxin);
            }

        }
        System.out.println(max);
    }
}

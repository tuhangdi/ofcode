package hiho521;

import java.util.Scanner;

/**
 * Created by thd on 2017/5/21.
 *
 * 题目1 : F1 Score
 时间限制:10000ms
 单点时限:1000ms
 内存限制:256MB
 描述
 小Hi和他的小伙伴们一起写了很多代码。时间一久有些代码究竟是不是自己写的，小Hi也分辨不出来了。

 于是他实现了一个分类算法，希望用机器学习实现自动分类。

 为了评价这个分类算法的优劣，他选出了N份有标记的代码作测试集，并决定用F1 Score作为评价标准。

 给出N份代码的实际作者是不是小Hi以及分类算法预测的结果，请你计算F1 Score。

 输入
 第一行包含一个整数N。(1 <= N <= 1000)

 以下N行每行包含两个字符(+或-)。第一个字符代表这份代码的实际作者是不是小Hi(+代表是，-代表不是)，第二个代表预测的作者是不是小Hi(+代表是，-代表不是)。

 输出
 一个百分数，X%，代表答案，X保留两位小数。

 样例输入
 4
 + +
 + -
 - +
 - -
 样例输出
 50.00%
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tp = 0;
        int fp = 0;
        int tn = 0;
        int fn = 0;
        String[] x = new String[n];
        String[] y = new String[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.next();
            y[i] = sc.next();
            if (x[i].equals("+") && y[i].equals("+")) tp++;
            else if (x[i].equals("-") && y[i].equals("+")) fp++;
            else if (x[i].equals("+") && y[i].equals("-")) tn++;
            else if (x[i].equals("-") && y[i].equals("-")) fn++;
        }
        double f1 = (double) 2 * tp / (2 * tp + fp + tn) * 100.0;
        String re = String.format("%.2f", f1);
        re = re + '%';
        System.out.println(re);
    }
}

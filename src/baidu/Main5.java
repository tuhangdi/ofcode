package baidu;

import java.util.Scanner;

/**
 * Created by thd on 2017/5/12.
 * 度度熊最近对全排列特别感兴趣,对于1到n的一个排列,度度熊发现可以在中间根据大小关系插入合适的大于和小于符号(即 '>' 和 '<' )使其成为一个合法的不等式数列。
 * 但是现在度度熊手中只有k个小于符号即('<'')和n-k-1个大于符号(即'>'),度度熊想知道对于1至n任意的排列中有多少个排列可以使用这些符号使其为合法的不等式数列。
 * 输入描述:
 * 输入包括一行,包含两个整数n和k(k < n ≤ 1000)
 * <p>
 * <p>
 * 输出描述:
 * 输出满足条件的排列数,答案对2017取模。
 * <p>
 * 输入例子:
 * 5 2
 * <p>
 * 输出例子:
 * 66
 */
public class Main5 {

    private static int num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int less = sc.nextInt();
        int large = n - less - 1;
        int[] s = new int[n];

        for (int i = 0; i < n; i++) {
            s[i] = i + 1;
        }
        permutation(s, 0, n - 1,less, large);
        System.out.println(num%2017);

    }

    public static void permutation(int[] s, int from, int to, int less, int large) {
        if (to <= 1)
            return;
        if (from == to) {
            int curless = 0;
            int curlarge = 0;
            for (int i = 0; i < to; i++) {
                if (s[i] > s[i + 1]) curless++;
                else curlarge++;
            }
            if (curless == less && curlarge == large) num++;
        } else {
            for (int i = from; i <= to; i++) {
                swap(s, i, from); //交换前缀，使其产生下一个前缀
                permutation(s, from + 1, to, less, large);
                swap(s, from, i); //将前缀换回，继续做上一个前缀的排列
            }
        }
    }

    public static void swap(int[] s, int i, int j) {
        int tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}

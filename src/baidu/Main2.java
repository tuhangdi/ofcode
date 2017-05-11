package baidu;



import java.util.Scanner;

/**
 * Created by thd on 2017/5/11.
 * 一个数轴上共有N个点，第一个点的坐标是度度熊现在位置，第N-1个点是度度熊的家。现在他需要依次的从0号坐标走到N-1号坐标。
 * 但是除了0号坐标和N-1号坐标，他可以在其余的N-2个坐标中选出一个点，并直接将这个点忽略掉，问度度熊回家至少走多少距离？
 * 输入描述:
 * 输入一个正整数N, N <= 50。
 * 接下来N个整数表示坐标，正数表示X轴的正方向，负数表示X轴的负方向。绝对值小于等于100
 * <p>
 * 输出描述:
 * 输出一个整数表示度度熊最少需要走的距离。
 * <p>
 * 输入例子:
 * 4
 * 1 4 -1 3
 * <p>
 * 输出例子:
 * 4
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 0;
        long[] num = new long[n];
        long sum = 0;
        long min = Long.MAX_VALUE;
        while (i < n) {

            num[i] = sc.nextInt();
            i++;
        }
        for (int j = 1; j < n - 1; j++) {
            int k = 1;
            sum = 0;
            while (k < n) {
                sum += Math.abs(num[k] - num[k - 1]);
                k++;
            }
            sum = sum - Math.abs(num[j] - num[j - 1]) - Math.abs(num[j + 1] - num[j]) + Math.abs(num[j + 1] - num[j - 1]);
            if (min > sum) min = sum;
        }
        System.out.println(min);
    }
}

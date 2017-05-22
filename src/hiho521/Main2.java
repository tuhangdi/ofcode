package hiho521;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by thd on 2017/5/21.
 * 题目2 : 数组重排2
 * 时间限制:10000ms
 * 单点时限:1000ms
 * 内存限制:256MB
 * 描述
 * 给定一个1-N的排列A1, A2, ... AN，每次操作小Hi可以选择一个数，把它放到数组的最左边。
 * <p>
 * 请计算小Hi最少进行几次操作就能使得新数组是递增排列的。
 * <p>
 * 输入
 * 第一行包含一个整数N。
 * <p>
 * 第二行包含N个两两不同整数A1, A2, ... AN。(1 <= Ai <= N)
 * <p>
 * 对于60%的数据 1 <= N <= 20
 * <p>
 * 对于100%的数据 1 <= N <= 100000
 * <p>
 * 输出
 * 一个整数代表答案
 * <p>
 * 样例输入
 * 5
 * 2 3 1 4 5
 * 样例输出
 * 1
 *
 *
 * 与百度题Main4类似，注意考虑完整情况。如-1 0 1 ， -1 1 0
 */
public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int[] num = new int[n];
            int[] xu = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = sc.nextInt();
                xu[i] = num[i];
            }
            Arrays.sort(xu);
            System.out.println(findMax(n, n, 0, num, xu, n-1));
        }
    }

    public static int findMax(int end, int n,int sum, int[] num, int[] xu, int xunum){
        if(end == 0) return sum;
        int max = Integer.MIN_VALUE;
        int maxI = 0;
        for(int i = 0; i < end; i++){
            if(num[i] > max){
                max = num[i];
                maxI = i;
            }
        }
        if(max<xu[xunum]) sum ++;
        sum += ( end-1 - maxI );
        return findMax(maxI,n, sum, num,xu,xunum-1);
    }
}

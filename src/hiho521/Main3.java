package hiho521;

import java.util.Scanner;

/**
 * Created by thd on 2017/5/21.
 * 时间限制:10000ms
 单点时限:1000ms
 内存限制:256MB
 描述
 给定一个1-N的排列A1, A2, ... AN，如果Ai和Aj满足i < j且Ai > Aj，我们就称(Ai, Aj)是一个逆序对。

 求A1, A2 ... AN中所有逆序对的数目。

 输入
 第一行包含一个整数N。

 第二行包含N个两两不同整数A1, A2, ... AN。(1 <= Ai <= N)

 对于60%的数据 1 <= N <= 1000

 对于100%的数据 1 <= N <= 100000

 输出
 一个整数代表答案

 样例输入
 5
 3 2 4 5 1
 样例输出
 5


 剑指offer36
 */

public class Main3 {
    private static long count;
    public static long InversePairs(int [] array) {
        if (array == null || array.length == 0) return 0;
        int[] temp = new int[array.length];
        sort(array, temp, 0, array.length - 1);
        return count ;
    }
    public static void sort(int [] array, int [] temp, int lo, int hi){
        if(hi <= lo) return;
        int mid = (lo + hi) >> 1;
        sort(array, temp, lo, mid);
        sort(array, temp, mid + 1, hi);
        merge(array, temp, lo, hi);
    }
    public static void merge(int [] array, int [] temp, int lo, int hi){
        int lowend = (lo + hi) >> 1;
        int highstart = lowend + 1;
        int lowstart = lo;
        int index = lo;
        while(lowstart <= lowend && highstart <= hi){
            if(array[lowstart] <= array[highstart]){
                temp[index ++] = array[lowstart ++];
            }
            else {
                count += (lowend - lowstart + 1);
                temp[index ++] = array[highstart ++];
            }
        }
        while (lowstart <= lowend){
            temp[index ++] = array[lowstart ++];
        }
        while (highstart <= hi){
            temp[index ++] = array[highstart ++];
        }
        for (int i = lo; i <= hi; i++){
            array[i] = temp[i];
        }
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int[] num = new int[n];
            int np = 0;
            for (int i = 0; i < n; i++) {
                num[i] = sc.nextInt();
            }

            System.out.println(InversePairs(num));
        }
    }
}

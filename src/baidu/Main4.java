package baidu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by thd on 2017/5/12.
 * 度度熊有一个N个数的数组，他想将数组从大到小排好序，但是萌萌的度度熊只会下面这个操作：
 任取数组中的一个数然后将它放置在数组的最后一个位置。
 问最少操作多少次可以使得数组从小到大有序？
 输入描述:
 首先输入一个正整数N，接下来的一行输入N个整数。(N <= 50, 每个数的绝对值小于等于1000)


 输出描述:
 输出一个整数表示最少的操作次数。

 输入例子:
 4
 19 7 8 25

 输出例子:
 2
 */
public class Main4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] num = new int[n];
        int [] xu = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = sc.nextInt();
            xu[i] = num[i];
        }

        Arrays.sort(xu);
        System.out.println(findMin(0,n,0,num,xu,0));

    }
    //递归寻找最小值，最小值前面数的个数就是本次的移动数，再找最小值后面的数的最小值时需要判断这个最小值是否是总体的次小值，若不是要加1.
    //例如，19，7,8,25，
    // 第一次找到7，由于7前面有一个值，因此移动次数是1，在7后面的数组中找最小值，第二次找到8，由于前面没有值且8是第二小，因此次数是0；第三次找到25，比19大，次数额加1。因此移动次数总共是2.
    public static int findMin(int start, int n,int sum, int[] num, int[] xu, int xunum){
        if(start == n) return sum;
        int min = Integer.MAX_VALUE;
        int minI = 0;
        for(int i = start; i < n; i++){
            if(num[i] < min){
                min = num[i];
                minI = i;
            }
        }
        if(min>xu[xunum]) sum ++;
        sum += ( minI - start );
        return findMin(minI+1,n, sum, num,xu,xunum+1);
    }
}

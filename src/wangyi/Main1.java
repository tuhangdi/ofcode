package wangyi;

import java.util.Scanner;

/**
 * Created by thd on 2017/5/15.
 * 一种双核CPU的两个核能够同时的处理任务，现在有n个已知数据量的任务需要交给CPU处理，假设已知CPU的每个核1秒可以处理1kb，每个核同时只能处理一项任务。
 * n个任务可以按照任意顺序放入CPU进行处理，现在需要设计一个方案让CPU处理完这批任务所需的时间最少，求这个最小的时间。
 * 输入描述:
 * 输入包括两行：
 * 第一行为整数n(1 ≤ n ≤ 50)
 * 第二行为n个整数length[i](1024 ≤ length[i] ≤ 4194304)，表示每个任务的长度为length[i]kb，每个数均为1024的倍数。
 * <p>
 * <p>
 * 输出描述:
 * 输出一个整数，表示最少需要处理的时间
 * <p>
 * 输入例子:
 * 5
 * 3072 3072 7168 3072 1024
 * <p>
 * 输出例子:
 * 9216
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] mission = new int[n];
        for (int i = 0; i < n; i++) {
            mission[i] = sc.nextInt();
        }
        for(int i = 1; i < (n+1)/2;i++){
            int j = 0;
            while(j < i){

            }
        }

    }
}

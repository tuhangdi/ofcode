package wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 11626 on 2017/3/25.
 * 小易拥有一个拥有魔力的手环上面有n个数字(构成一个环),当这个魔力手环每次使用魔力的时候就会发生一种奇特的变化：每个数字会变成自己跟后面一个数字的和(最后一个数字的后面一个数字是第一个),一旦某个位置的数字大于等于100就马上对100取模(比如某个位置变为103,就会自动变为3).现在给出这个魔力手环的构成，请你计算出使用k次魔力之后魔力手环的状态。
 输入描述:
 输入数据包括两行：
 第一行为两个整数n(2 ≤ n ≤ 50)和k(1 ≤ k ≤ 2000000000),以空格分隔
 第二行为魔力手环初始的n个数，以空格分隔。范围都在0至99.


 输出描述:
 输出魔力手环使用k次之后的状态，以空格分隔，行末无空格。

 输入例子:
 3 2
 1 2 3

 输出例子:
 8 9 7
 */
public class Main5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] num = new int[n];
            for (int i = 0; i < n; i ++){
                num[i] = sc.nextInt();
            }
            for (int i = 0;i < k; i ++){
                int[] temp = Arrays.copyOf(num,num.length);
                for (int j = 0; j < n; j ++){
                    num[j] = (temp[j] + temp[(j + 1)%n])%100;
                }
            }
            int i = 0;
            for (;i < n - 1;++i){
                System.out.print(num[i] + " ");
            }
            System.out.println(num[i]);
        }
    }
}

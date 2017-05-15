package wangyi;

import java.util.Scanner;
/**
 * Created by 11626 on 2017/3/25.
 * 在幼儿园有n个小朋友排列为一个队伍，从左到右一个挨着一个编号为(0~n-1)。其中有一些是男生，有一些是女生，男生用'B'表示，女生用'G'表示。小朋友们都很顽皮，当一个男生挨着的是女生的时候就会发生矛盾。作为幼儿园的老师，你需要让男生挨着女生或者女生挨着男生的情况最少。你只能在原队形上进行调整，每次调整只能让相邻的两个小朋友交换位置，现在需要尽快完成队伍调整，你需要计算出最少需要调整多少次可以让上述情况最少。例如：
 GGBBG -> GGBGB -> GGGBB
 这样就使之前的两处男女相邻变为一处相邻，需要调整队形2次
 输入描述:
 输入数据包括一个长度为n且只包含G和B的字符串.n不超过50.


 输出描述:
 输出一个整数，表示最少需要的调整队伍的次数

 输入例子:
 GGBBG

 输出例子:
 2
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            String str = scan.next();
            int count1 = 0;
            int count2 = 0;
            char[] ch1 = str.toCharArray();
            char[] ch2 = ch1.clone();
            if(ch1.length <= 1||ch1 == null){
                System.out.println(0);
                continue;
            }
            for (int i = ch1.length - 1;i >= 0;--i){
                for (int j = 0;j < i;++j){
                    if (ch1[j + 1] == 'B' && ch1[j] == 'G'){
                        count1++;
                        ch1[j + 1] = 'G';
                        ch1[j] = 'B';
                    }
                }
            }
            for (int i = ch2.length - 1;i >= 0;--i){
                for (int j = 0;j < i;++j){
                    if (ch2[j + 1] == 'G' && ch2[j] == 'B'){
                        count2++;
                        ch2[j + 1] = 'B';
                        ch2[j] = 'G';
                    }
                }
            }
            if(count1<=count2)
                System.out.println(count1);
            else
                System.out.println(count2);

        }
    }
}


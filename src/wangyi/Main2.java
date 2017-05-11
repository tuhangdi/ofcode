package wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 11626 on 2017/3/25.
 */
public class Main2 {
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

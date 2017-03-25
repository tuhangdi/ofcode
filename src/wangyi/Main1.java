package wangyi;

import java.util.Scanner;
/**
 * Created by 11626 on 2017/3/25.
 */
public class Main1 {
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


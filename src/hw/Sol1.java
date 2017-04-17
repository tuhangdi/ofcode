package hw;

import java.util.Scanner;

/**
 * Created by thd on 2017/4/17
 * .计算字符串最后一个单词的长度，单词以空格隔开
 * 一行字符串，非空，长度小于5000。
 * 输出描述：整数N，最后一个单词的长度。
 *
 * 输入：hello world
 * 输出：5
 */
public class Sol1 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while (sc.hasNextLine()){
           String str = sc.nextLine();
           char[] strs = str.toCharArray();
           int length = 0;
           for(int i = 0; i < str.length(); i ++){
               if(strs[i] == ' ') length = 0;
               else
                   length ++;
           }
            System.out.println(length);
        }

    }
}

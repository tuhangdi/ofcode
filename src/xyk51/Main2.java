package xyk51;

import java.util.Scanner;

/**
 * Created by thd on 2017/9/18
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.indexOf("u51") != -1){
                count++;
            }
        }
        System.out.println(count);

    }
}

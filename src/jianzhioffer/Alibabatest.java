package jianzhioffer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by thd on 2017/3/15.
 * 对于一个由一位十进制整数构成的二叉树，如果深度不超过4，可以用一个三位十进制整数构成的数组表示，具体规则如下：
 * 1.百位数表示树的层次L，1<=L<=4；十位数表示在该层次中的位置P，1<=P<=8;个位数标书数值V。
 * 如[113,215,221],有路径3-5,3-1，路径和为3+5+3+1=12
 */
public class Alibabatest {
    public static void main(String[] args) {

        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        while(line != null && !line.isEmpty()) {
            int value = Integer.parseInt(line.trim());
            if(value == 0) break;
            inputs.add(value);
            line = in.nextLine();
        }
        int[] A = new int[inputs.size()];
        for(int i=0; i<inputs.size(); i++) {
            A[i] = inputs.get(i).intValue();
        }
        int res = resolve(A);

        System.out.println(String.valueOf(res));
    }

    // write your code here
    public static int resolve(int[] A) {
        return 0;
    }
}

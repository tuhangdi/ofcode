package hw0712;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by thd on 2017/7/12.
 * 打印任务排序
 */
public class Main2 {//排序不行，要用
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        if (st.length() == 0) return;
        String[] s = st.replace(" ", "").split(",");
        int[] input = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            int value = Integer.valueOf(s[i]);
            input[i] = value;
        }
        int[] output = new int[input.length];
        output = printOrder(input, output);
        for (int i = 0; i < output.length - 1; i++) {
            System.out.print(output[i] + ", ");
        }
        System.out.print(output[output.length - 1]);
    }
    public static int[] printOrder(int input[], int output[]) {
        int[] tempput = new int[input.length];
        int[] orderput = new int[input.length];
        int[] n = new int[input.length];
        System.arraycopy(input,0, tempput,0, input.length);
        Arrays.sort(tempput);
        for (int i = 0; i < tempput.length; i++) {
            orderput[i] = tempput[tempput.length - i - 1];
        }
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < tempput.length; j++) {
                if (orderput[j] == input[i] && n[j] != 1) {
                    output[i] = j;
                    n[j] = 1;
                    break;
                }
            }
        }
        return output;
    }
}

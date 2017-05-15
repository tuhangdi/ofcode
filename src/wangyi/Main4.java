package wangyi;


import java.util.*;

/**
 * Created by thd on 2017/5/15.
 * 小易有一个长度为n序列，小易想移除掉里面的重复元素，但是小易想是对于每种元素保留最后出现的那个。小易遇到了困难,希望你来帮助他。
 * 输入描述:
 * 输入包括两行：
 * 第一行为序列长度n(1 ≤ n ≤ 50)
 * 第二行为n个数sequence[i](1 ≤ sequence[i] ≤ 1000)，以空格分隔
 * <p>
 * <p>
 * 输出描述:
 * 输出消除重复元素之后的序列，以空格分隔，行末无空格
 * <p>
 * 输入例子:
 * 9
 * 100 100 100 99 99 99 100 100 100
 * <p>
 * 输出例子:
 * 99 100
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sequence = new int[n];
        Map<Integer, Integer> su = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sequence[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int fin = -1;
            for (int j = i; j < n; j++) {
                if (sequence[i] == sequence[j]) fin = j;
            }
            su.put(fin, sequence[i]);
        }
        for (int i = 0; i < n; i++) {
            if (su.containsKey(i)) {
                sb.append(su.get(i));
                sb.append(" ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        String s = sb.toString();
        System.out.println(s);
    }
}

package baidu;

import java.util.*;

/**
 * Created by thd on 2017/5/11.
 * <p>
 * 度度熊想去商场买一顶帽子，商场里有N顶帽子，有些帽子的价格可能相同。度度熊想买一顶价格第三便宜的帽子，问第三便宜的帽子价格是多少？
 * 输入描述:
 * 首先输入一个正整数N（N <= 50），接下来输入N个数表示每顶帽子的价格（价格均是正整数，且小于等于1000）
 * <p>
 * <p>
 * 输出描述:
 * 如果存在第三便宜的帽子，请输出这个价格是多少，否则输出-1
 * <p>
 * 输入例子:
 * 10
 * 10 10 10 10 20 20 30 30 40 40
 * <p>
 * 输出例子:
 * 30
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 0;
        Set<Integer> num = new HashSet<>();
        while (i < n) {
            int next = sc.nextInt();
            num.add(next);
            i++;

        }
        if (num.size() < 3) {
            System.out.println(-1);
        } else {
            List<Integer> list = new ArrayList<>();
            for (int j : num) {
                list.add(j);
            }
            Collections.sort(list);
            System.out.println(list.get(2));
        }
    }
}

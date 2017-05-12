package baidu;

import java.text.DecimalFormat;
import java.util.Scanner;

import static java.lang.Math.*;


/**
 * Created by thd on 2017/5/11.
 * 三维空间中有N个点，每个点可能是三种颜色的其中之一，三种颜色分别是红绿蓝，分别用'R', 'G', 'B'表示。
 * 现在要找出三个点，并组成一个三角形，使得这个三角形的面积最大。
 * 但是三角形必须满足：三个点的颜色要么全部相同，要么全部不同。
 * 输入描述:
 * 首先输入一个正整数N三维坐标系内的点的个数.(N <= 50)
 * <p>
 * 接下来N行，每一行输入 c x y z，c为'R', 'G', 'B' 的其中一个。x，y，z是该点的坐标。(坐标均是0到999之间的整数)
 * <p>
 * <p>
 * 输出描述:
 * 输出一个数表示最大的三角形面积，保留5位小数。
 * <p>
 * 输入例子:
 5
 R 0 0 0
 R 0 4 0
 R 0 0 3
 G 92 14 7
 G 12 16 8
 * <p>
 * 输出例子:
 * 6.00000
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        int[] z = new int[n];
        char[] color = new char[n];
        double maxarea = -Double.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            char[] tep = s.toCharArray();
            color[i] = tep[0];
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            z[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((color[i] == color[j] && color[j] == color[k]) || ((color[i] != color[j]) && (color[i] != color[k]) && (color[j] != color[k]))) {
                        double side0 = sqrt(pow(x[i] - x[j], 2) + pow(y[i] - y[j], 2) + pow(z[i] - z[j], 2));
                        double side1 = sqrt(pow(x[i] - x[k], 2) + pow(y[i] - y[k], 2) + pow(z[i] - z[k], 2));
                        double side2 = sqrt(pow(x[k] - x[j], 2) + pow(y[k] - y[j], 2) + pow(z[k] - z[j], 2));
                        if (side0 + side1 <= side2 || side0 + side2 <= side1 || side1 + side2 <= side0) {
                            continue;
                        }
                        double p = (side0 + side1 + side2) / 2;
                        double area = sqrt(p * (p - side0) * (p - side1) * (p - side2));
                        if (area > maxarea) maxarea = area;
                    }
                }
            }
        }
        DecimalFormat df = new DecimalFormat("###.00000");
        System.out.println(df.format(maxarea));
    }
}

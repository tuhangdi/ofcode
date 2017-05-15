package wangyi;

import java.util.Scanner;

/**
 * Created by 11626 on 2017/3/25.
 * 终于到周末啦！小易走在市区的街道上准备找朋友聚会，突然服务器发来警报,小易需要立即回公司修复这个紧急bug。假设市区是一个无限大的区域，每条街道假设坐标是(X，Y)，小易当前在(0，0)街道，办公室在(gx,gy)街道上。小易周围有多个出租车打车点，小易赶去办公室有两种选择，一种就是走路去公司，另外一种就是走到一个出租车打车点，然后从打车点的位置坐出租车去公司。每次移动到相邻的街道(横向或者纵向)走路将会花费walkTime时间，打车将花费taxiTime时间。小易需要尽快赶到公司去，现在小易想知道他最快需要花费多少时间去公司。
 * 输入描述:
 * 输入数据包括五行:
 * <p>
 * 第一行为周围出租车打车点的个数n(1 ≤ n ≤ 50)
 * <p>
 * 第二行为每个出租车打车点的横坐标tX[i] (-10000 ≤ tX[i] ≤ 10000)
 * <p>
 * 第三行为每个出租车打车点的纵坐标tY[i] (-10000 ≤ tY[i] ≤ 10000)
 * <p>
 * 第四行为办公室坐标gx,gy(-10000 ≤ gx,gy ≤ 10000),以空格分隔
 * <p>
 * 第五行为走路时间walkTime(1 ≤ walkTime ≤ 1000)和taxiTime(1 ≤ taxiTime ≤ 1000),以空格分隔
 * <p>
 * <p>
 * 输出描述:
 * 输出一个整数表示，小易最快能赶到办公室的时间
 * <p>
 * 输入例子:
 * 2
 * -2 -2
 * 0 -2
 * -4 -2
 * 15 3
 * <p>
 * 输出例子:
 * 42
 */


public class Main2 {

    public static void main(String[] args) {
        int x;
        int i, j, k;
        int n, m;
        Scanner sc = new Scanner(System.in);
        int N = 500 + 10;
        long xx[] = new long[N];
        long y[] = new long[N];
        long gx, gy;
        while (sc.hasNext()) {
            n = sc.nextInt();
            for (i = 0; i < n; ++i) {
                xx[i] = sc.nextLong();
            }
            for (i = 0; i < n; ++i) {
                y[i] = sc.nextLong();
            }
            gx = sc.nextLong();
            gy = sc.nextLong();
            xx[n] = gx;
            y[n] = gy;
            long walkTime, taxiTime;
            walkTime = sc.nextLong();
            taxiTime = sc.nextLong();
            long mint = fun(gx) + fun(gy);
            mint *= walkTime;
            for (i = 0; i < n; i++) {
                long s = walkTime * (fun(xx[i]) + fun(y[i]));
                long ts = taxiTime * (fun(xx[i] - gx) + fun(y[i] - gy));
                mint = Math.min(mint, s + ts);
            }
            System.out.println(mint);

        }
    }

    public static long fun(long a) {
        if (a > 0) {
            return a;
        } else {
            return -a;
        }
    }

}
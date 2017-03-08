import java.util.Scanner;

/**
 * Created by thd on 2017/3/8.
 * 一个被称为 “数字三角形” 的 n(n 不超过 200) 层迷宫，这个迷宫的第 i 层有 i 个房间，分别编号为 1..i。
 * 除去最后一层的房间，每一个房间都会有一些通往下一层的房间的楼梯，
 * 用符号来表示的话，就是从第 i 层的编号为 j 的房间出发会有两条路，一条通向第 i+1 层的编号为 j 的房间，另一条会通向第 i+1 层的编号为 j+1 的房间，
 * 而最后一层的所有房间都只有一条离开迷宫的道路。这样的道路都是单向的，
 * 每个房间里都会生成一定数量的奖券，这些奖券可以在通过迷宫之后兑换各种奖品。
 * 已知每个房间里的奖券数量，计算最多能获得多少奖券。
 */
public class Dp {
    private static int MAXN = 105;
    private static int[][] dp= new int[MAXN][MAXN];
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while(in.hasNext())
        {
            int n=Integer.parseInt(in.next());
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<=i;j++)
                {
                    dp[i][j]=Integer.parseInt(in.next());
                }
            }
            for(int i=n-1;i>=0;i--)
            {
                for(int j=0;j<=i;j++)
                {
                    dp[i][j]+=Math.max(dp[i+1][j], dp[i+1][j+1]);
                }
            }
            System.out.println(dp[0][0]);
        }
        in.close();
    }
}

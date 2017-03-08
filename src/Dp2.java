import java.util.Scanner;

/**
 * Created by thd on 2017/3/8.
 * 小 Ho 现在手上有 M 张奖券，而奖品区有 N 件奖品，分别标号为 1 到 N，其中第 i 件奖品需要 need(i) 张奖券进行兑换，同时也只能兑换一次，
 * 小 Ho 给每件奖品都评了分，其中第 i 件奖品的评分值为 value(i), 表示他对这件奖品的喜好值。
 * 现在他想知道，凭借他手上的这些奖券，可以换到哪些奖品，使得这些奖品的喜好值之和能够最大。
 * 输入样例：
 *5 1000
 144 990
 487 436
 210 673
 567 58
 1056 897
 */
public class Dp2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int [] dp = new int[M+1];
        int [] value = new int[N];
        int [] need = new int[N];
        for(int i = 0; i < N; i++){
            need[i] = in.nextInt();
            value[i] = in.nextInt();
        }
        for(int i = 0; i < N; i++) {
            for (int j = M; j >= need[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - need[j - 1]] + value[i]);
            }
        }
        System.out.println(dp[M]);
    }
}

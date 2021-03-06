package wangyi;

import java.util.Scanner;

/**
 * Created by thd on 2017/5/16.
 * [编程题] 分饼干
 * 时间限制：1秒
 * 空间限制：32768K
 * 易老师购买了一盒饼干，盒子中一共有k块饼干，但是数字k有些数位变得模糊了，看不清楚数字具体是多少了。
 * 易老师需要你帮忙把这k块饼干平分给n个小朋友，易老师保证这盒饼干能平分给n个小朋友。现在你需要计算出k有多少种可能的数值
 * 输入描述:
 * 输入包括两行：
 * <p>
 * 第一行为盒子上的数值k，模糊的数位用X表示，长度小于18(可能有多个模糊的数位)
 * <p>
 * 第二行为小朋友的人数n
 * <p>
 * <p>
 * 输出描述:
 * 输出k可能的数值种数，保证至少为1
 * <p>
 * 输入例子:
 * 9999999999999X
 * 3
 * <p>
 * 输出例子:
 * 4
 */

/**
 * 分析：
 动态规划。定义一个二维数组dp[i][j]，
 i表示输入数值的长度，明显i取在0到输入数值长度之间的值，比如输入的数是10位，那么i应该取在0到10之间的数；
 j表示余数，则j应该取在0到n-1之间的数，比如，小盆友的人数是3，则j可以取到0,1,2。
 理解了这个二维数组的大致情况，接下来要说dp[i][j]到底表示的是啥，
 这里我们是这么定义的：dp[i][j]表示长度为i的数 除以小朋友的人数之后得到的余数为j的个数。
 其实如果数字确定（如果不包含X），则对于确定的i,只有一个dp[i][j]为1，但是由于X位可以从0-9中选择，所以不止有一个，
 最后返回dp[length][0]就是长度为length，余数为0(整除)的个数。这里length就是数值K的长度。
 那么状态转移方程该怎么写呢，
 举个例子，对于确定的数值K=1244，小朋友个数n=3来说，如果当前的i为走到了3，也就是我们只看124这三位，那么算出余数j为1，也就是说对于这个特殊的例子dp[3][1]=1；
 那么当i=4的时候，我们现在要看1244了，那我们怎么更新呢，来看1244除以3的过程，其实前面完全就是124除以3，只不过得到过程中的余数1之后，要和最后的4拼接构成14，再和3除，得到最后的余数2，那这时候其实，新的余数是j=2，也就是dp[4][2]+=dp[3][1].
 上述情况如果理解了，现在就把最后那个4 换成X，那么这时候，由于X可以从0到9，所以我们得到的新余数应该是newJ=（1*10+X）%3，这样由于X不定，我们可以更新很多值，但是这更新的新余数，都来自这个旧余数，或者依赖于他，也就是说，现在
 dp[4][newJ]+=dp[3][1];
 * */
public class Main12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int kid = sc.nextInt();
        long[][] dp = new long[20][200000];
        char[] ch = s.toCharArray();
        dp[0][0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < kid; j++) {
                for (int k = 0; k < 10; k++) {
                    if (ch[i - 1] - '0' != k && ch[i - 1] >= '0' && ch[i - 1] <= '9') continue;
                    int newJ = (j * 10 + k) % kid;
                    dp[i][newJ] += dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[s.length()][0]);
    }
}

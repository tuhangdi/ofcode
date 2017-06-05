package leetcode.DP;

/**
 * Created by thd on 2017/6/5.
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 给定一个正整数n，将其分解为至少两个正整数的和，并最大化这些整数的乘积。 返回您可以获得的最大值。
 For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

 Note: You may assume that n is not less than 2 and not larger than 58.

 首先证明拆出的因子大于 4 是不行的。设 x 是一个因子，x>4，那么可以将这个因子再拆成两个因子 x−2 和 2，易证 (x−2)×2>x。所以不能有大于 4 的因子。
 一个数 x 当它大于 3 时，有 (x−2)×2>(x−1)×1。
 因此只剩下2和3。可证明3比2好，这里不展开。
 （如果因子不限于整数的话， e 是最佳的选择）
 */
public class n343IntegerBreak {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n==3) return 2;
        int res = 1;
        while (n>4){
            res *= 3;
            n -=3;
        }
        res *= n;
        return res;
    }

    public static void main(String[] args) {
        n343IntegerBreak n = new n343IntegerBreak();
        System.out.println(n.integerBreak(7));
    }
}

package leetcode;

/**
 * Created by thd on 2017/6/1.
 * , x, where 0 ≤ x < 10^n.
 * <p>
 * Example:
 * Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 * <p>
 * 求所有各个位数字不同的数。
 * 当n=1时因为只有一个数字，所以0-9都是答案．
 * 当n>=2时，最高位可以为1-9任意一个数字，之后各位可以选择的数字个数依次为9, 8, 7, 6...，上一位选一个下一位就少了一种选择．
 */
public class CountNumbersWithUniqueDigits357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 1) return 10;
        if (n == 0) return 1;
        int val = 9;
        int num = 10;
        for (int i = 2; i <= n; i++) {
            val *= (9 - i + 2);
            num += val;
        }
        return num;
    }

    public static void main(String[] args) {
        CountNumbersWithUniqueDigits357 c = new CountNumbersWithUniqueDigits357();
        System.out.println(c.countNumbersWithUniqueDigits(3));
    }
}

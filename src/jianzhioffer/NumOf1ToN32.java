package jianzhioffer; /**
 * Created by thd on 2017/3/9.
 *求出 1~13 的整数中 1 出现的次数, 并算出 100~1300 的整数中 1 出现的次数？
 * 为此他特别数了一下 1~13 中包含 1 的数字有 1、10、11、12、13 因此共出现 6 次, 但是对于后面问题他就没辙了。
 * ACMer 希望你们帮帮他, 并把问题更加普遍化, 可以很快的求出任意非负整数区间中 1 出现的次数。
 */
/**
 *
 1. 如果第 i 位（自右至左，从 1 开始标号）上的数字小于 x ，则第 i 位可能出现 1 的次数由更高位决定（若没有高位，视高位为 0），等于更高位数字 X 当前位数的权重 10^(i-1)。
 2. 如果第 i 位上的数字等于 x，则第 i 位上可能出现 x 的次数不仅受更高位影响，还受低位影响（若没有低位，视低位为 0），等于更高位数字 X 当前位数的权重 10^(i-1) + （低位数字 + 1）。
 3. 如果第 i 位上的数字大于 x，则第 i 位上可能出现 x 的次数仅由更高位决定（若没有高位，视高位为 0），等于（更高位数字 + 1）X 当前位数的权重 10^(i-1)。
 *
 */
public class NumOf1ToN32 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int x = 1, i = 1, sum = 0, num, numdown,tmp;
        int numup = n;
        while(numup != 0) {
            numup = n / (int) Math.pow(10, i);
            tmp = n % (int) Math.pow(10, i);
            num = tmp / (int) Math.pow(10, i - 1);
            numdown = tmp % (int) Math.pow(10, i - 1);
            if (num > x) {
                sum += (numup + 1) * (int) Math.pow(10, i - 1);
            }
            else if (num < x) {
                sum += numup * (int) Math.pow(10, i - 1);
            } else {
                sum += numup * (int) Math.pow(10, i - 1) + (numdown + 1);
            }
            i++;
        }
        return sum;
    }
    public static void main(String[] args){
        NumOf1ToN32 n = new NumOf1ToN32();
        System.out.println(n.NumberOf1Between1AndN_Solution(5));
        System.out.println(n.NumberOf1Between1AndN_Solution(10));
        System.out.println(n.NumberOf1Between1AndN_Solution(55));
        System.out.println(n.NumberOf1Between1AndN_Solution(99));
        System.out.println(n.NumberOf1Between1AndN_Solution(0));
        System.out.println(n.NumberOf1Between1AndN_Solution(1));
        System.out.println(n.NumberOf1Between1AndN_Solution(1000));
        System.out.println(n.NumberOf1Between1AndN_Solution(21235));
    }
}

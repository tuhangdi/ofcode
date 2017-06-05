package leetcode.DP;

/**
 * Created by thd on 2017/6/5.
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * 给定一个非负整数num。 对于范围为0≤i≤num的每个数字，我们计算其二进制表示中的1的数量并将其作为数组返回。
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * <p>
 * 0 ， 1， 10， 11， 100， 101， 110， 111。从1开始，0、1交叉增加，res[i]=res[i/2]+i%2
 */
public class n338CountingBits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for (int i = 1; i <= num; i++) {
            res[i] = res[i / 2] + i % 2;
        }
        return res;
    }

    public static void main(String[] args) {
        n338CountingBits n = new n338CountingBits();
        int[] res = n.countBits(2);
        for (int i : res) {
            System.out.println(i);
        }
    }
}

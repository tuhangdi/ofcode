package leetcode.Array;

/**
 * Created by thd on 2017/9/4
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 两个整数之间的汉明距离是相应位不同的位置数。
 Given two integers x and y, calculate the Hamming distance.
 给定两个整数x和y，计算汉明距离。
 Note:
 0 ≤ x, y < 231.

 Example:

 Input: x = 1, y = 4

 Output: 2

 Explanation:
 1   (0 0 0 1)
 4   (0 1 0 0)
        ↑   ↑

 The above arrows point to positions where the corresponding bits are different.

 xor异或
 */
public class n461HammingDistance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        n461HammingDistance n = new n461HammingDistance();
        System.out.println(n.hammingDistance(1, 5));
    }
}

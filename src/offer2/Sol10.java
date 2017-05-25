package offer2;

/**
 * Created by thd on 2017/5/25.
 * 题目描述
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Sol10 {
    public int NumberOf1(int n) {
        int count = 0;
        long flag = 1;
        while (n != 0) {
            count++;
            n = n & (n - 1);//将最右边的1变为0！！！！！！！！！！！
        }
        return count;
    }

    public static void main(String[] args) {
        Sol10 s = new Sol10();
        System.out.println(s.NumberOf1(-2147483648));
    }
}

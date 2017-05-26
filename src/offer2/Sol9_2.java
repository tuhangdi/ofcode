package offer2;

/**
 * Created by thd on 2017/5/25.
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Sol9_2 {
    public int JumpFloorII(int target) {
        if (target == 0 || target == 1) return target;

        int[] f = new int[target+1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= target; i++) {
            for (int j = 0; j < i; j++) {
                f[i] += f[j];
            }
        }
        return f[target];
    }

    public static void main(String[] args) {
        Sol9_2 s = new Sol9_2();
        System.out.println(s.JumpFloorII(4));
    }
}

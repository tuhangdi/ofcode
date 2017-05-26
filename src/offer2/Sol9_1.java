package offer2;

/**
 * Created by thd on 2017/5/25.
 * 题目描述
 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Sol9_1 {
    public int JumpFloor(int target) {
        if(target <=2) return target;
        int[] fb = new int[target];
        fb[0] = 1;
        fb[1] = 2;
        for (int i = 2; i < target; i++) {
            fb[i] = fb[i-1] +fb[i-2];
        }
        return fb[target -1];

    }

    public static void main(String[] args) {
        Sol9_1 s = new Sol9_1();
        System.out.println(s.JumpFloor(10));
    }
}

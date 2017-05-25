package offer2;

/**
 * Created by thd on 2017/5/25.
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Sol9_3 {
    public int RectCover(int target) {
        if (target <=1)return target;
        int[] fb= new int [target];
        fb[0] = 1;
        fb[1] = 2;
        for (int i = 2; i < target; i++) {
            fb[i] = fb[i-1] + fb[i-2];
        }
        return fb[target-1];
    }

    public static void main(String[] args) {
        Sol9_3 s = new Sol9_3();
        System.out.println(s.RectCover(5));
    }
}

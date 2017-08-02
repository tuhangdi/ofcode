package pdd801;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by thd on 2017/8/1
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        long [] nums= new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }
        Arrays.sort(nums);
        long res1 = 1;
        long res2 = 1;
        for (int i = nums.length - 1; i > nums.length - 4; i--) {
            res1 *= nums[i];
        }
        res2 = nums[0] * nums[1] * nums[nums.length - 1];
        System.out.println(Math.max(res1, res2));
    }
}

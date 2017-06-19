package nowcoder616;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by thd on 2017/6/16.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            max = Math.max(max,Math.abs(nums[i] - nums[i+2]));
        }
        max = Math.max(max, Math.abs(nums[0] - nums[1]));
        max = Math.max(max, Math.abs(nums[n-2]) - nums[n - 1]);
        System.out.println(max);
    }
}

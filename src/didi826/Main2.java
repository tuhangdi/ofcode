package didi826;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by thd on 2017/8/26
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strs = s.split(" ");
        int[] nums = new int[strs.length];
        for(int i=0;i<strs.length;i++){
            nums[i] = Integer.parseInt(strs[i]);
        }
        int k = sc.nextInt();

        Arrays.sort(nums);
        System.out.println(nums[nums.length - k]);
    }
}

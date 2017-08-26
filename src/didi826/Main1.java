package didi826;

import java.util.Scanner;

/**
 * Created by thd on 2017/8/26
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strs = s.split(" ");
        int[] nums = new int[strs.length];
        for(int i=0;i<strs.length;i++){
            nums[i] = Integer.parseInt(strs[i]);
        }
        if (nums.length == 1){
            System.out.println(nums[0]);
            return;
        }
        int tempMax = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tempMax = Math.max(nums[i] , nums[i] + tempMax);
            max = Math.max(tempMax, max);
        }
        System.out.println(max);
    }
}

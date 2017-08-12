package netease812;

import java.util.Scanner;

/**
 * Created by thd on 2017/8/12
 */
public class Main2_2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] res = new int[n];
        int j = 0;
        int k = n - 1;
        int i = n - 1;
        while (j <= k){
            if (j <= k) {
                res[j++] = nums[i];
            }
            else break;
            i--;
            if (j <= k) {
                res[k--] = nums[i];
            } else break;
            i-- ;
        }
        for (int l = 0; l < n - 1; l++) {
            System.out.print(res[l] + " ");
        }
        System.out.print(res[n - 1]);
    }
}

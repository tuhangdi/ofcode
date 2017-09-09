package netease0909;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by thd on 2017/9/9
 */


public class Main3 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in

        );
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int gap = 0;
        int max_index = 0;
        for(int i=0;i<n;i++) {
            b[i] = sc.nextInt();
            a[i] = b[i];
        }
        Arrays.sort(a);

        for(int i=0;i<n-1;i++) {
            int tmp = Math.abs(a[i+1] - a[i]);
            if(tmp > gap) {
                gap = tmp;
                max_index = a[i];
            }
        }
        int[] arr1 = new int[n];
        int t1 = 0;
        int t2 = 0;
        int[] arr2 = new int[n];

        for(int i=0;i<n;i++) {
            if(b[i] <= max_index) {
                arr1[t1] = b[i];
                t1++;
            } else {
                arr2[t2] = b[i];
                t2++;
            }
        }
        int sum = 0;
        for(int i=0;i<t1-1;i++) {
            sum += Math.abs(arr1[i+1] - arr1[i]);
        }
        for(int i=0;i<t2-1;i++) {
            sum += Math.abs(arr2[i+1] - arr2[i]);
        }
        System.out.println(sum);
    }
}

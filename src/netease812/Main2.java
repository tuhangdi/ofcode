package netease812;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by thd on 2017/8/12
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        //StringBuffer sb = new StringBuffer();
        Deque<Integer> sb = new LinkedList<>();
        int i = 0;
        int num = n;
        if (num % 2 != 0) {
            while (i < n) {
                if (i < n)
                    sb.addFirst(nums[i]);
                else
                    break;
                i++;
                if (i < n)
                    sb.addLast(nums[i]);
                else break;
                i++;
            }
        }
        else {
            while (i < n) {
                if (i < n)
                    sb.addLast(nums[i]);
                else break;
                i++;

                if (i < n)
                    sb.addFirst(nums[i]);
                else
                    break;
                i++;

            }
        }
        for (int j = 0; j < n - 1; j++) {
            System.out.print(sb.removeFirst() + " ");
        }
        System.out.print(sb.removeFirst());

    }

}

package jianzhioffer;

import java.util.ArrayList;

/**
 * Created by thd on 2017/3/7.
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Getminnum30 {
    //利用快排但不排完, O(n)算法，但是需要修改输入的数组,切取出数字不是顺序的。
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> leastNumbers = new ArrayList<>();
        if (input.length == 0 || k > input.length || k<= 0)
            return leastNumbers;
        if(input.length == k){
            for(int i = 0;i < k; i++){
                leastNumbers.add(input[i]);
            }
            return leastNumbers;
        }
        int start = 0;
        int end = input.length - 1;
        int index = part(input, start, end);
        while (index != k - 1){
            if (index > k - 1){
                end = index - 1;
                index = part(input, start, end);
            }
            else {
                start = index + 1;
                index = part(input, start, end);
            }
        }
        for (int i = 0; i < k; i++){
            leastNumbers.add(input[i]);
            System.out.println(input[i]);
        }
        return leastNumbers;
    }
    public int part(int [] input, int start, int end) {
        int index = input[start];
        int i = start;
        int j = end + 1;
        while (true) {
            while (input[++i] < index) {
                if (i == end)
                    break;
            }
            while (input[--j] >= index) {
                if (j == start)
                    break;
            }
            if(i >= j) break;
            swap(input, i, j);
        }
        swap(input, start, j);
        return j;
    }
    public int[] swap(int[] arr, int i, int j){
        int tmp;
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        return arr;
    }

    //O(nlogk)的算法，特别适合处理海量数据
    public ArrayList<Integer> GetLeastNumbers_Head(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (k > input.length) {
            return res;
        }// 1. 建立大顶堆
        for (int i = k / 2 - 1; i >= 0; i --) {
            buildBigHeap(input, i, k);
        }
// 2. 堆排序       
        for (int i = k; i < input.length; i ++) {
            if (input[0] > input[i]) {
                input[0] = input[i];
                buildBigHeap(input, 0, k);
            }
        }
        // 3. 筛选        
        for (int i = 0; i < k; i ++) {
            res.add(input[i]);
            System.out.println(input[i]);
        }
        return res;
    }
    private void buildBigHeap(int[] input, int n, int k) {
        while (n < k) {
            int left = 2 * n + 1;
            int right = 2 * n + 2;
            int original = n;
            if (left < k && input[left] > input[n]) {
                n = left;
            }
            if (right < k && input[right] > input[n]) {
                n = right;}
            if (n != original) {
                int tmp = input[n];
                input[n] = input[original];
                input[original] = tmp;}
            else {
                break;
            }
        }
    }


    public static void main(String[] args){
        int [] input = {4,5,1,6,2,7,3,8};
        Getminnum30 gn = new Getminnum30();
        gn.GetLeastNumbers_Head(input, 4);
        gn.GetLeastNumbers_Solution(input, 8);
    }
}

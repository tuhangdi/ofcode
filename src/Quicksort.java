package src;

import java.util.Collections;
import java.util.Random;

/**
 * Created by thd on 2017/2/24.
 */
public class Quicksort {
    public int[] quickSort(int[] data, int lo, int hi){
        int j = part(data, lo, hi);
        if(j > lo)
            quickSort(data, lo, j-1);
        if(j < hi)
            quickSort(data, j+1, hi);
        return data;
    }
    public int part(int[] data,int lo,int hi){
        int index = data[lo];
        int i = lo+1;
        int j = hi;
        while(true) {
            while (data[i] < index) {
                if (i == hi) break;
                ++i;
            }
            while (data[j] > index) {
                if (j == lo) break;
                --j;
            }
            if (i >= j) break;
            int tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
        }
        int tmp = data[lo];
        data[lo] = data[j];
        data[j] = tmp;
        return j;
    }
    public static void main(String[] args){
        int[] data = {6,4,3,2,1};
        Quicksort qs = new Quicksort();
        int[] dat = new int[5];
        dat = qs.quickSort(data, 0, data.length-1);
        for(int i : dat)
            System.out.println(i);
    }
}

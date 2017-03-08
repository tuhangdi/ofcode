

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
        int i = lo;
        int j = hi + 1;
        while(true) {
            while (data[++i] <= index) {
                if (i == hi) break;
            }
            while (data[--j] > index) {
                if (j == lo) break;
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
        int[] data = {6,2,2,2,1};
        Quicksort qs = new Quicksort();
        int[] dat = new int[5];
        dat = qs.quickSort(data, 0, data.length-1);
        for(int i : dat)
            System.out.println(i);
    }
}

package jianzhioffer;

/**
 * Created by thd on 2017/3/10.
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组, 求出这个数组中的逆序对的总数 P。并将 P 对 1000000007 取模的结果输出。 即输出 P%1000000007
 * 例如{7,5,6,4}中有5个逆序对，(7,6), (7,5), (7,4), (6,4) ,(5,4)。
 */
public class Arraypairs36 {
    private long count;
    public int InversePairs(int [] array) {
        if (array == null || array.length == 0) return 0;
        int[] temp = new int[array.length];
        sort(array, temp, 0, array.length - 1);
        return (int) (count % 1000000007);
    }
    public void sort(int [] array, int [] temp, int lo, int hi){
        if(hi <= lo) return;
        int mid = (lo + hi) >> 1;
        sort(array, temp, lo, mid);
        sort(array, temp, mid + 1, hi);
        merge(array, temp, lo, hi);
    }
    public void merge(int [] array, int [] temp, int lo, int hi){
        int lowend = (lo + hi) >> 1;
        int highstart = lowend + 1;
        int lowstart = lo;
        int index = lo;
        while(lowstart <= lowend && highstart <= hi){
            if(array[lowstart] <= array[highstart]){
                temp[index ++] = array[lowstart ++];
            }
            else {
                count += (lowend - lowstart + 1) % 1000000007;
                temp[index ++] = array[highstart ++];
            }
        }
        while (lowstart <= lowend){
            temp[index ++] = array[lowstart ++];
        }
        while (highstart <= hi){
            temp[index ++] = array[highstart ++];
        }
        for (int i = lo; i <= hi; i++){
            array[i] = temp[i];
        }
    }
    public static void main(String[] args){
        int[] array = {1,2,3,7,6,5,0};
        Arraypairs36 ap = new Arraypairs36();
        System.out.println(ap.InversePairs(array));
    }
}

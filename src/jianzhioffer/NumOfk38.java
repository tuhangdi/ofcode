package jianzhioffer;

/**
 * Created by thd on 2017/3/16.
 *
 * 统计一个数字在排序数组中出现的次数。
 * 例如输入排序数组{1, 2, 3, 3, 3, 3, 4, 5}和数字3，由于3在这个数组中出现了4次，因此输出4.
 */
public class NumOfk38 {
    //二分查找法，分别找到第一个数和最后一个数。
    public int GetNumberOfK(int [] array , int k) {
        int num = 0;
        if (array.length != 0 && array != null){
            int first = GetFirstK(array, k, 0, array.length - 1);
            int last = GetLastK(array, k, 0, array.length - 1);
            if (first > -1 && last > -1)
                num = last - first + 1;
        }
        return num;
    }
    public int GetFirstK(int [] array, int k, int start, int end){
        if (start > end)
            return -1;
        int middleIndex = (start + end) >> 1;
        int middleData = array[middleIndex];
        if (middleData == k){
            if ((middleIndex > 0 && array[middleIndex - 1] != k) || middleIndex == 0)
                return middleIndex;
            else
                end = middleIndex - 1;
        }
        else if (middleData > k){
            end = middleIndex - 1;
        }
        else {
            start = middleIndex + 1;
        }
        return GetFirstK(array, k, start, end);
    }
    public int GetLastK(int [] array, int k, int start, int end){
        if (start > end)
            return -1;
        int middleIndex = (start + end) >> 1;
        int middleData = array[middleIndex];
        if (middleData == k){
            if ((middleIndex < array.length - 1 && array[middleIndex + 1] != k) || middleIndex == array.length - 1)
                return middleIndex;
            else
                start = middleIndex + 1;
        }
        else if (middleData > k)
            end = middleIndex - 1;
        else
            start = middleIndex + 1;
        return GetLastK(array, k, start, end);
    }
    public static void main(String[] args){
        NumOfk38 nok = new NumOfk38();
        int [] array = {1,2,3,3,3,3,4,5};
        System.out.println(nok.GetNumberOfK(array, 3));
    }
}

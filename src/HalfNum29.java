/**
 * Created by thd on 2017/3/6.
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class HalfNum29 {
    //基于快排的O(n)算法,即找该数组的中位数。
    public int MoreThanHalfNum_Solution(int [] array) {
        if(CheckInvalidArray(array, array.length))
            return 0;
        int middle = array.length >> 1;
        int start = 0;
        int end = array.length - 1;
        Quicksort qs = new Quicksort();
        int index = qs.part(array, start, end);
        while (index != middle){
            if (index > middle){
                end = index - 1;
                index = qs.part(array, start, end);
            }
            else{
                start = index + 1;
                index = qs.part(array, start, end);
            }
        }
        int result = array[middle];
        if(!CheckMoreThanHalf(array, array.length, result))
            result = 0;
        return result;
    }
    private boolean g_bInputInvalid = false;
    public boolean CheckInvalidArray(int[] array, int length){
        g_bInputInvalid = false;
        if(array == null || length <= 0)
            g_bInputInvalid = true;
        return  g_bInputInvalid;
    }
    public boolean CheckMoreThanHalf(int[] array, int length, int number){
        int times = 0;
        for (int i = 0; i < length; i++){
            if(array[i] == number)
                times++;
        }
        boolean isMoreThanHale = true;
        if(times * 2 <= length){
            g_bInputInvalid = true;
            isMoreThanHale = false;
        }
        return isMoreThanHale;
    }
    //根据数据特点找出O(n)的算法。题目意思可以理解为这个数出现的次数比其他所有数字出现次数的和还要多。
    //遍历时保存两个值，一个是数组中的一个数字，一个是次数，
    // 当遍历下一个数字的时候，如果下一个数字和之前保存的一样，次数加1；不一样，次数减1,；次数为0，保存下一个数字，并把次数设为1。
    public int MoreThanHalfNum(int[] array){
        if(CheckInvalidArray(array, array.length))
            return 0;
        int result = array[0];
        int times = 1;
        for(int i = 1; i < array.length; i++){
            if(times == 0)
                result = array[i];
            if(result == array[i])
                times++;
            else
                times--;
        }
        if(!CheckMoreThanHalf(array, array.length, result))
            return 0;
        return result;
    }

    public static void main(String[] args){
        int[] array = {1,2,3,2,2,2,5,4,2};
        HalfNum29 hn = new HalfNum29();
        System.out.println(hn.MoreThanHalfNum_Solution(array));
        System.out.println(hn.MoreThanHalfNum(array));
    }
}

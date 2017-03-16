/**
 * Created by thd on 2017/3/8.
 * 输入一个整数数组，数组中一个或连续的多个数组组成一个子数组。
 * 求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * 例如输入的数组为{1，-2,3,10,-4,7,2，-5}，最大的子数组为{3,10，-4,7,2}。和为18。
 */
public class SumOfSubarray31 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int sum = 0;
        int findsum = 0x80000000;  //- 2147483648，int 的最小值。;
        int start = 0, end = 0, finalstart = 0, finalend = 0;//
        if(array.length == 0 || array == null) return 0;
        for(int i = 0; i < array.length; i++){
            if(sum <= 0) {
                sum = array[i];
                start = i;//
                end = i;//
            }
            else {
                sum += array[i];
                end++;//
            }
            if(sum > findsum) {
                findsum = sum;
                finalstart = start;//
                finalend = end;//
            }

        }
        for(int i = finalstart; i <= finalend; i++){//
            System.out.println(array[i]);//
        }
        System.out.println(findsum);//
        return findsum;
    }



    //dp
    public int FindSum(int[] array){
        int sum = 0;
        int findsum = 0x80000000;
        for(int i = 0; i < array.length; i++){
            sum = Math.max(sum + array[i], array[i]);
            findsum = Math.max(sum, findsum);
        }
        System.out.println(findsum);
        return findsum;
    }


    public static void main(String[] args){
        int [] array = {-1,-2,-3,-10};
        SumOfSubarray31 ss = new SumOfSubarray31();
        ss.FindGreatestSumOfSubArray(array);
        ss.FindSum(array);
    }
}

package jianzhioffer;

/**
 * Created by thd on 2017/3/17.
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度O(n)，空间复杂度事O(1)。
 *
 */
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class FindNum40 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array.length < 2) return;
        int flag = 1;
        int resultXOR = 0;
        for (int i = 0; i < array.length; i ++){//从头到尾异或数组中的每个数字
            resultXOR ^= array[i];
        }
        while ((resultXOR & flag) == 0) flag <<= 1;

        for (int i = 0; i < array.length; i ++){
            if ((flag & array[i]) == 0) num2[0] ^= array[i];
            else num1[0] ^= array[i];

        }
    }
}

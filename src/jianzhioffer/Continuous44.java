package jianzhioffer;

import java.util.Arrays;

/**
 * Created by thd on 2017/3/24.
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2~10为数字本身，A为1，J为11，Q为12，K为13，而大王小王可以看成任一数字
 */
public class Continuous44 {
    public boolean isContinuous(int [] numbers) {
        if (numbers.length < 5) return  false;
        Arrays.sort(numbers);
        int num0 = 0;
        for (int i = 0; i < numbers.length && numbers[i] == 0; i ++){
            num0 ++;
        }
        int small = num0;
        int big = num0 + 1;
        int gap = 0;
        while(big < numbers.length){
            if (numbers[small] == numbers[big]) return false;
            gap += numbers[big] - numbers[small] - 1;
            small = big;
            big ++;
        }
        if(gap > num0)
            return false;
        else
            return true;
    }
    public static void main(String[] args){
        int[] num = {7,0,0,4,1};
        Continuous44 c = new Continuous44();
        System.out.println(c.isContinuous(num));
    }
}

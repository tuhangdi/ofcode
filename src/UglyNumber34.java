/**
 * Created by thd on 2017/3/10.
 * 把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 例如 6、8 都是丑数，但 14 不是，因为它包含因子 7。
 * 习惯上我们把 1 当做是第一个丑数。
 * 求按从小到大的顺序的第 N 个丑数。
 */
public class UglyNumber34 {
    //逐个判断每个整数是不是丑数的解法，直观但不够高效
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0) return 0;
        int number = 0;
        int ugly = 0;
        while(ugly < index){
            number ++;
            if(isUgly(number))
                ugly++;
        }
        return number;
    }
    private boolean isUgly(int number){
        while(number % 2 == 0)
            number /= 2;
        while (number % 3 == 0)
            number /= 3;
        while (number % 5 == 0)
            number /= 5;
        return (number == 1) ? true : false;
    }



    //创建数组保存已找到的丑数，用空间换时间的解法。
    public int GetUglyNumber(int index){
        if(index == 0 || index == 1) return index;
        int [] uglyArray = new int[index];
        uglyArray[0] = 1;
        int nextUglyNum = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        while(nextUglyNum < index){
            uglyArray[nextUglyNum] = Math.min(uglyArray[t2] * 2, Math.min(uglyArray[t3] * 3, uglyArray[t5] * 5));
            while (uglyArray[t2] * 2 <= uglyArray[nextUglyNum])
                t2++;
            while (uglyArray[t3] * 3 <= uglyArray[nextUglyNum])
                t3++;
            while (uglyArray[t5] * 5 <= uglyArray[nextUglyNum])
                t5++;
            nextUglyNum ++;
        }
        return uglyArray[nextUglyNum - 1];
    }
    public static void main(String [] args){
        UglyNumber34 un = new UglyNumber34();
        System.out.println(un.GetUglyNumber(1500));
    }
}

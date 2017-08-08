package jianzhioffer;

/**
 * Created by thd on 2017/2/24.
 */
public class Jump {
    //裴波那契数列变种：0,1,2,3,5。。。
    public int JumpFloor(int target) {
        if(target == 1) return 1;
        if(target == 0) return 0;
        int f1 = 0;
        int f2 = 1;
        int sum = 0;
        for(int i = 0; i < target; i++)
        {
            sum =f1 + f2;
            f1 = f2;
            f2 = sum;
        }
        return sum;
    }
}

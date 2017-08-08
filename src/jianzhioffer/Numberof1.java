package jianzhioffer;

/**
 * Created by thd on 2017/2/24.
 */
public class Numberof1 {
    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while(flag != 0){
            if((n & flag) != 0)
                count++;
            flag = flag << 1;
        }
        return count;
    }
    //把一个整数减去1，再和原整数做与运算，会把该整数最右边的1变为0.
    public int NumberOf1b(int n){
        int count = 0;
        while (n != 0){
            count++;
            n = n & (n-1);
        }
        return count;
    }
    public static void main(String[] args){
        Numberof1 nb = new Numberof1();
        System.out.println(nb.NumberOf1(9));
        System.out.println(nb.NumberOf1b(9));
    }
}

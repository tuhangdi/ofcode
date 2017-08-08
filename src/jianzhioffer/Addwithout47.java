package jianzhioffer;

/**
 * Created by thd on 2017/3/24.
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 +、-、*、/ 四则运算符号。
 */
public class Addwithout47 {
    public int Add(int num1,int num2) {
        int sum = 0, carry;
        if(num1 == 0) sum = num2;
        if(num2 == 0) sum = num1;
        while (num2 != 0){
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }
        return sum;
    }
    public static void main(String[] args){
        Addwithout47 a = new Addwithout47();
        System.out.println(a.Add(3,0));
    }
}

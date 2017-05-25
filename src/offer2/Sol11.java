package offer2;

/**
 * Created by thd on 2017/5/25.
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Sol11 {
    public double Power(double base, int exponent) {
        if(exponent  == 0) return 1;
        if(exponent == 1) return base;
        double result;
        if (exponent>0) {
             result = Pi(base, exponent);
        }
        else {
             result = Pi(base, -exponent);
            result = 1/result;
        }
        return result;

    }
    public double Pi(double base, int exponent){
        if(exponent  == 0) return 1;
        if(exponent == 1) return base;
        double result = Pi(base, exponent>> 1);
        result *= result;
        if(exponent%2!=0) result *= base;//针对次方奇偶。
        return result;
    }

    public static void main(String[] args) {
        Sol11 s = new Sol11();
        System.out.println(s.Power(2,-3));
    }
}

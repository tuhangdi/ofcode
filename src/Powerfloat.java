/**
 * Created by thd on 2017/2/28.
 */
public class Powerfloat {
    //考虑exponent为负，以及0的负次幂不存在时用全局标志位
    boolean flag = false;
    public double Power(double base, int exponent) {
        int abs = 0;
        flag = false;
        double result = base;
        if(base == 0 && exponent < 0){
            flag = true;
            return 0;
        }
        if(exponent < 0) abs = -exponent;
        else abs = exponent;
        //result = PowerP(base, abs);
        result = PowerFi(base, abs);
        if(exponent < 0) result = 1 / result;
        return result;
    }
    public double PowerP(double base, int abs){
        double result = 1.0;
        for(int i = 0; i < abs; i++){
            result *= base;
        }
        return  result;
    }
    //例如exponent = 32,则等于是base的16次方在平方，base的8次方的平方的平方。。。可以用递归做。奇数次方要多乘一个base
    public double PowerFi(double base, int exponent){
        if(exponent == 0) return 0;
        if(exponent == 1) return base;
        double result = PowerFi(base, exponent >> 1); //右移一位相当于除以2
        result *= result;
        if ((exponent & 1) == 1){//相当于%
            result *= base;
        }
        return  result;
    }
    public static void main(String[] args){
        Powerfloat pf = new Powerfloat();
        System.out.println(pf.Power(4.5,3));
        System.out.println(pf.Power(0,-1));
        System.out.println(pf.Power(4.5,-3));

    }

}

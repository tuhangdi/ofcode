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
        for(int i = 1; i < abs; i++){
            result *= base;
        }
        if(exponent < 0) result = 1 / result;
        return result;
    }
    public static void main(String[] args){
        Powerfloat pf = new Powerfloat();
        System.out.println(pf.Power(4.5,3));
        System.out.println(pf.Power(0,-1));
        System.out.println(pf.Power(4.5,-3));
    }

}

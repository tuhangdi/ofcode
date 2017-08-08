package jianzhioffer;

/**
 * Created by thd on 2017/3/24.
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为 0 或者字符串不是一个合法的数值则返回 0
 */
public class Stringtoint49 {
    public int StrToInt(String str) {
        if (str.length() == 0 || str == null) return 0;
        char[] strs = str.toCharArray();
        int result = 0;
        boolean isPositive = true;
        if (strs[0] == '-') isPositive = false;
        for (int i = 0; i < strs.length; i ++) {
           if(strs[i] == '+' || strs[i] == '-') continue;
           if(strs[i]< '0' || strs[i] > '9') return 0;
            result = result * 10 + strs[i] - '0';
        }
        return isPositive ?  result : result * -1;
    }
    public static void main(String[] args){
        Stringtoint49 st = new Stringtoint49();
        String s = "-1a24";
        System.out.println(st.StrToInt(s));
    }
}

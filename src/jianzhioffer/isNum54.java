package jianzhioffer;

/**
 * Created by thd on 2017/4/17.
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class isNum54 {
    public boolean isNumeric(char[] str) {
        if (str.length == 0 || str == null)
            return false;
        int strIndex = 0;
        if(str[strIndex] == '+' || str[strIndex] == '-')
            strIndex ++;
        if(strIndex == str.length)
            return false;
        boolean numeric = false;
        strIndex = scanDigits(str, strIndex);
        if (strIndex != str.length){
            if (str[strIndex] == '.'){
                strIndex ++;
                strIndex = scanDigits(str, strIndex);

                if (strIndex != str.length && (str[strIndex] == 'e' || str[strIndex] == 'E'))
                    numeric = isExp(str, strIndex);
                if(strIndex == str.length)
                    numeric = true;
            }
            else if (strIndex != str.length && (str[strIndex] == 'e' || str[strIndex] == 'E'))
                numeric = isExp(str, strIndex);
            else
                numeric = false;
        }
        else
            numeric = true;
        return numeric ;
    }
    public int scanDigits(char[] str, int strIndex){
        while(strIndex != str.length && str[strIndex] >= '0' && str[strIndex] <= '9')
            strIndex ++;
        return strIndex;
    }
    public boolean isExp(char[] str, int strIndex){
        strIndex ++;
        if (strIndex == str.length)
            return false;
        if (str[strIndex] == '+' || str[strIndex] == '-')
            strIndex ++;

        strIndex = scanDigits(str, strIndex);
        return (strIndex == str.length) ? true : false;
    }

    public static void main(String[] args){
        String s = "3.14156";
        char[] str = s.toCharArray();
        isNum54 n = new isNum54();
        if (n.isNumeric(str))
            System.out.println(s + ": true");
        else
            System.out.println(s + ": false");
    }
}

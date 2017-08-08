package jianzhioffer;

/**
 * Created by thd on 2017/3/20.
 * 字符串的左旋转操作时把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 例如，字符序列 S=”abcXYZdef”, 要求输出循环左移 3 位后的结果，即 “XYZdefabc”。
 */
public class LeftRotate42_1 {
    public String LeftRotateString(String str,int n) {
        char[] strs = str.toCharArray();
        if (strs != null) {
            if (n > 0 && strs.length > 0 && n < strs.length){
                int firstBegin = 0;
                int firstEnd = n - 1;
                int secondBegin = n;
                int secondEnd = strs.length - 1;
                Reverseword42 rw = new Reverseword42();
                rw.Reverse(strs, firstBegin, firstEnd);
                rw.Reverse(strs, secondBegin, secondEnd);
                rw.Reverse(strs, firstBegin, secondEnd);
            }
        }
        return new String(strs);
    }
    public static void main(String[] args){
        String str = "abcXYZdef";
        LeftRotate42_1 lr = new LeftRotate42_1();
        System.out.println(lr.LeftRotateString(str, 3));
    }

}

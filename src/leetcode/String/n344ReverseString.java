package leetcode.String;

/**
 * Created by thd on 2017/6/19.
 * Write a function that takes a string as input and returns the string reversed.
 编写一个将字符串作为输入并返回字符串的函数。
 Example:
 Given s = "hello", return "olleh".

 */
public class n344ReverseString {
    public String reverseString(String s) {
        char[] ch = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
    return new String(ch);
    }

    public static void main(String[] args) {
        n344ReverseString n = new n344ReverseString();
        System.out.println(n.reverseString("hello"));
    }
}

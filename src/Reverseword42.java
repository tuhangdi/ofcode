
/**
 * Created by thd on 2017/3/20.
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 *例如， “I am a student.”是“student. a am I”。
 */
public class Reverseword42 {
    public String ReverseSentence(String str) {
        if (str.isEmpty()) return str;
        char[] strs = str.toCharArray();
        int begin = 0;
        int end = strs.length - 1;
        Reverse(strs, begin, end);
        end = 0;
        while (begin != strs.length - 1){
            if (strs[begin] == ' ') {
                begin++;
                end++;
            }
            else if (strs[end] == ' '){
                Reverse(strs, begin, end - 1);
                begin = ++ end;
            }
            else if (end == strs.length - 1){
                Reverse(strs, begin, end);
                begin = end;
            }
            else
                end ++;
        }

        return (new String(strs));
    }
    public char[] Reverse(char[] strs, int begin, int end){
        while(begin < end){
            char temp = strs[begin];
            strs[begin] = strs[end];
            strs[end] = temp;
            begin ++;
            end --;
        }
        return strs;
    }
    public static void main(String[] args){
        String strs = "";
        Reverseword42 rw = new Reverseword42();
        System.out.println(rw.ReverseSentence(strs));
    }
}

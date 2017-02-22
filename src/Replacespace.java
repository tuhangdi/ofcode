/**
 * Created by thd on 2017/2/22.
 */
public class Replacespace {
    //扩大当前字符串的大小，从后往前排，空格后面的字符串只需移动一次，O(n).
    public String replaceSpace(StringBuffer str) {
        int spacenum = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' ')
                spacenum++;
        }
        int indexOrinal = str.length() - 1;
        int newLength = str.length() + spacenum * 2;
        int indexNew = newLength - 1;
        str.setLength(newLength);
        for(;indexOrinal >= 0 && indexOrinal < newLength; --indexOrinal){
            if(str.charAt(indexOrinal) == ' '){
                str.setCharAt(indexNew--, '0');
                str.setCharAt(indexNew--, '2');
                str.setCharAt(indexNew--, '%');
            }
            else str.setCharAt(indexNew--, str.charAt(indexOrinal));
        }
        return str.toString();
    }
    //从前往后插，最后以新字符串返回。
    public String replaceSpace2(StringBuffer str){
        StringBuffer strnew = new StringBuffer();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                strnew.append("%20");
            }
            else strnew.append(str.charAt(i));
        }
        return strnew.toString();
    }

    public static void main(String[] args){
        StringBuffer str = new StringBuffer("hello world");
        Replacespace rs = new Replacespace();
        System.out.println(rs.replaceSpace(str));
        System.out.println(rs.replaceSpace2(str));
    }
}

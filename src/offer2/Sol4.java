package offer2;

/**
 * Created by thd on 2017/5/24.
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Sol4 {
    public String replaceSpace(StringBuffer str) {
        char[] s = str.toString().toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length; i++) {
            if (s[i] != ' ')
                sb.append(s[i]);
            else
                sb.append("%20");
        }
        String ss = sb.toString();
        return ss;
    }

    public static void main(String[] args) {
        StringBuffer s = new StringBuffer();
        s.append("We Are Happy");
        Sol4 ss = new Sol4();
        System.out.println(ss.replaceSpace(s));
    }
}

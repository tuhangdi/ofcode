package leetcode.String;

/**
 * Created by thd on 2017/6/19.
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string.
 * If there are less than k characters left, reverse all of them.
 * 如果剩下的字符少于k个字符，则反转所有字符。
 * If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 如果小于2k但大于或等于k个字符，则反转第一个k个字符并将另一个作为原始字符。
 Example:
 Input: s = "abcdefg", k = 2
 Output: "bacdfeg"
 */
public class n541ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2*k) {
            if  ((s.length() - i) < k){
                ch = reverseI(ch, i, s.length() - 1);
                break;
            }
            ch = reverseI(ch, i, i+k-1);
        }
        return new String(ch);
    }
    public char[] reverseI(char[] ch, int start, int end){
        while(start < end){
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
        return ch;
    }

    public static void main(String[] args) {
        n541ReverseStringII n = new n541ReverseStringII();
        System.out.println(n.reverseStr("abcdefg", 2));
    }
}

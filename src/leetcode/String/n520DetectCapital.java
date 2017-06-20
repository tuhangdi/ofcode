package leetcode.String;

import javax.print.DocFlavor;

/**
 * Created by thd on 2017/6/20.
 * Given a word, you need to judge whether the usage of capitals in it is right or not.

 We define the usage of capitals in a word to be right when one of the following cases holds:

 All letters in this word are capitals, like "USA".
 All letters in this word are not capitals, like "leetcode".
 Only the first letter in this word is capital if it has more than one letter, like "Google".
 Otherwise, we define that this word doesn't use capitals in a right way.


 这个词中的所有字母都是大写，如“美国”。
 这个词中的所有字母都不是大写字母，例如“leetcode”。
 只有这个词中的第一个字母是大写，如果它有多个字母，如“Google”。
 否则，我们定义这个词不以正确的方式使用大写字母。

 Example 1:
 Input: "USA"
 Output: True

 Example 2:
 Input: "FlaG"
 Output: False


 */
public class n520DetectCapital {
    public boolean detectCapitalUse(String word) {
        char[] ch = word.toCharArray();
        boolean allUp = true;
        boolean allLow =true;
        if (Character.isLowerCase(ch[0])) {
            allUp = false;
        }
        for (int i = 1; i < ch.length; i++) {
            if (Character.isLowerCase(ch[i])) {
                allUp = false;
            }
            else{
                allLow = false;
            }
        }
        return allUp || allLow;
    }

    public static void main(String[] args) {
        n520DetectCapital n = new n520DetectCapital();
        System.out.println(n.detectCapitalUse("FlaG"));
    }
}

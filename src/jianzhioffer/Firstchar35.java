package jianzhioffer;

import java.util.LinkedHashMap;

/**
 * Created by thd on 2017/3/10.
 * 在一个字符串 (1<= 字符串长度 <=10000，全部由大写字母组成) 中找到第一个只出现一次的字符, 并返回它的位置
 */
public class Firstchar35 {
    public int FirstNotRepeatingChar(String str) {
        if (str.isEmpty() || str.length() == 0) return 0;
        LinkedHashMap<Character, Integer> findChar = new LinkedHashMap<>();//linkedhashmap 底层是链表，可以根据顺序存储。比如说输入 c，a，hashmap 存储计算出 c，a 的 hash 值，有可能存成 a，c，而 linked 存储为 c，a 不会改变输入顺序
        char[] strs = str.toCharArray();
        for(int i = 0; i < str.length(); i++){
            if(!findChar.containsKey(strs[i])) findChar.put(strs[i], 1);
            else findChar.put(strs[i], findChar.get(strs[i]) + 1);
        }
        int i = 0;
        while(i < str.length()){
            if(findChar.get(strs[i]) == 1)
                break;
            i++;
        }
        return i;
    }
}

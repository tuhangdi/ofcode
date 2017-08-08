package jianzhioffer;

/**
 * Created by thd on 2017/3/7.
 * 用kmp算法求子字符串数量
 */
public class Kmp {
    public int [] GetNext(char[] pattern){
        int [] next = new int[pattern.length];
        next[0] = 0;
        int j = 0;
        for(int i = 1; i < pattern.length; i++){
            while(j != 0 && pattern[j] != pattern[i])
                j = next[j-1];
            if(pattern[i] == pattern[j])
                j++;
            next[i] = j;

        }
        return next;
    }
    public int StringKmp(char[] strs, char[] pattern){
        int[] next = GetNext(pattern);
        int i, j;
        int sum = 0;
        for(i = 0,j =0 ; i < strs.length; i++){
            while(j != 0 && strs[i] != pattern[j])
                j = next[j -1];
            if(strs[i] == pattern[j])
                j++;
            if(j == pattern.length) {
                sum++;
                j = next[j - 1];
            }
        }
        return sum;
    }
    public static void main(String[] args){
        String str = "bababbaabababbab";
        String pa = "bab";
        char[] strs = str.toCharArray();
        char[] pattern = pa.toCharArray();
        Kmp km = new Kmp();
        System.out.println(km.StringKmp(strs, pattern));
    }
}

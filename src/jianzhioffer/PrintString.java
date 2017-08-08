package jianzhioffer;

import java.util.*;

/**
 * Created by thd on 2017/3/6.
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class PrintString {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str == null || str.isEmpty()) return list;
        if(str != null && str.length() > 0) {
            FullPermutation(str.toCharArray(), 0, list);
        }
        Collections.sort(list);
        return list;
    }
    //递归实现的全排列
    private void FullPermutation(char [] str, int begin, ArrayList<String> list){
        if(begin == str.length -1) {
            list.add(String.valueOf(str));
            System.out.println(String.valueOf(str));
        }
        else {
            Set<Character> charSet = new HashSet<>();
            for(int j = begin; j < str.length; j++){
                if(j == begin || !charSet.contains(str[j])){//去重判断
                    charSet.add(str[j]);
                    swap(str, begin, j);//交换元素，相当于固定第begin个元素
                    FullPermutation(str, begin+1, list);//求这种情况下的全排列算法。
                    swap(str, j, begin);//还原成原来的数组，便于下一次全排列。
                }
            }
        }
    }
    private void swap(char[] str, int i, int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    //dfs
    private boolean [] marked;
    private char [] seqs;
    private  HashSet<String> result = new HashSet<String>();//set用于去重
    public ArrayList<String> PermutationDfs(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str == null || str.isEmpty()) return null;
        char[] strs = str.toCharArray();
        seqs = new char[strs.length];
        marked = new boolean[strs.length];
        dfs(strs, 0);
        list.addAll(result);
        Collections.sort(list);
        return list;
    }
    private void dfs(char [] arrs, int step){
        if(step == arrs.length){
            String str = "";
            for(int i = 0; i < seqs.length; i++){
                str += seqs[i];
            }
            System.out.println(String.valueOf(str));
            result.add(str);
            return;
        }
        for(int i = 0; i < arrs.length; i++){
            if(!marked[i]){
                seqs[step] = arrs[i];
                marked[i] = true;
                dfs(arrs, step + 1);
                marked[i] = false;
            }
        }
    }

    public static void main(String[] args){
        PrintString ps = new PrintString();
        String str = "abc";
        ps.Permutation(str);
        System.out.println("....dfs................");
        ps.PermutationDfs(str);
    }
}

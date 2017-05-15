package baidu;

import java.util.Arrays;

/**
 * Created by thd on 2017/5/12.
 * 度度熊最近对全排列特别感兴趣,对于1到n的一个排列,度度熊发现可以在中间根据大小关系插入合适的大于和小于符号(即 '>' 和 '<' )使其成为一个合法的不等式数列。
 * 但是现在度度熊手中只有k个小于符号即('<'')和n-k-1个大于符号(即'>'),度度熊想知道对于1至n任意的排列中有多少个排列可以使用这些符号使其为合法的不等式数列。
<<<<<<< HEAD
 * 输入描述:
 * 输入包括一行,包含两个整数n和k(k < n ≤ 1000)
 * <p>
 * <p>
 * 输出描述:
 * 输出满足条件的排列数,答案对2017取模。
 * <p>
 * 输入例子:
 * 5 2
 * <p>
 * 输出例子:
 * 66
 */
public class Main5 {

    private static int num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int less = sc.nextInt();
        int large = n - less - 1;
        int[] s = new int[n];
=======
 输入描述:
 输入包括一行,包含两个整数n和k(k < n ≤ 1000)
>>>>>>> 10ec6751826655863e2ef1752fdedbdc783f3292


 输出描述:
 输出满足条件的排列数,答案对2017取模。

 输入例子:
 5 2

 输出例子:
 66
 */
public class Main5 {
    public static void main(String[] args){
        int[] array=new int[]{1,2,3,4,5,6};
        permute(array,0);
    }
    public static void permute(int[] array,int start){
        if(start==array.length){

        }
        else
            for(int i=start;i<array.length;++i){
                swap(array,start,i);  //  交换元素
                permute(array,start+1);  //交换后，再进行全排列算法
                swap(array,start,i);  //还原成原来的数组，便于下一次的全排列
            }
    }

    private static void swap(int[] array,int s,int i){
        int t=array[s];
        array[s]=array[i];
        array[i]=t;
    }
}

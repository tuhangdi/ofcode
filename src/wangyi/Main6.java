package wangyi;

import java.util.Scanner;

/**
 * Created by thd on 2017/5/16.
 * [编程题] 工作安排
 * 时间限制：1秒
 * 空间限制：32768K
 * 现在有n位工程师和6项工作(编号为0至5)，现在给出每个人能够胜任的工作序号表(用一个字符串表示，比如：045，表示某位工程师能够胜任0号，4号，5号工作)。
 * 现在需要进行工作安排，每位工程师只能被安排到自己能够胜任的工作当中去，两位工程师不能安排到同一项工作当中去。
 * 如果两种工作安排中有一个人被安排在的工作序号不一样就被视为不同的工作安排，现在需要计算出有多少种不同工作安排计划。
 * 输入描述:
 * 输入数据有n+1行：
 * 第一行为工程师人数n(1 ≤ n ≤ 6)
 * 接下来的n行，每行一个字符串表示第i(1 ≤ i ≤ n)个人能够胜任的工作(字符串不一定等长的)
 * <p>
 * <p>
 * 输出描述:
 * 输出一个整数，表示有多少种不同的工作安排方案
 * <p>
 * 输入例子:
 * 6
 * 012345
 * 012345
 * 012345
 * 012345
 * 012345
 012345
 * <p>
 * 输出例子:
 * 720
 */

/*
* 首先现根据输入的字符串创建二位数组，横坐标为人，纵坐标为工作，可以做为1，不能做为0，
* 进行深搜（dfs）,i代表遍历到第i个人，当i=sum时，所以人均以遍历完成，工作分配完成。
* s从工作0到工作5进行遍历，创建数组mid存储已经分配出去的工作，1为已分配，0为未分配，
* 当工作未分配且第i个人可以完成，mid值给1,递归调用dfs给i+1个人分配工作，当所有i+1均以搜索完成，dfs结束，mid[s]给0，接着沿着s进行遍历。
* */
public class Main6 {
    static int n;
    static int[][] vector;
    static int[] mid;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String temp = sc.nextLine();
        vector = new int[n][6];
        mid = new int[6];

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            char[] ch = s.toCharArray();
            for (int j = 0; j < ch.length; j++) {
                vector[i][ch[j] - '0'] = 1;
            }
        }
        dfs(0);
        System.out.println(count);
    }
    public static void dfs(int i){
        if(i == n) {
            count++;
            return;
        }

        for(int s =0; s< 6;s++){
            if(mid[s] ==0 && vector[i][s] ==1){
                mid[s] = 1;
                dfs(i+1);
                mid[s] =0;
            }
        }
    }
}

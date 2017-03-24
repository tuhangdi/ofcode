/**
 * Created by thd on 2017/3/24.
 * 0,1,...,n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。
 * 求出这个圆圈里剩下的最后一个数字。
 */
public class LastNum45 {
    //数组模拟循环队列
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) return -1;
        int[] circle = new int[n];
        int count = n;
        int i = -1;
        int step = 0;
        while(count > 0){
            i++;
            if( i == n) i = 0;
            if(circle[i] == -1) continue;
            step ++;
            if(step == m){
                circle[i] = -1;
                count --;
                step = 0;
            }
        }
        return i;
    }
    public int LastRemaining(int n, int m){
        if(n < 1 || m < 1) return -1;
        int last = 0;
        for(int i = 2; i <= n; i ++){
            last = (last + m) % i;
        }
        return last;
    }
    public static void main(String[] args){
        LastNum45 ln = new LastNum45();
        System.out.println(ln.LastRemaining_Solution(5,3));
        System.out.println(ln.LastRemaining(5,3));
    }
}

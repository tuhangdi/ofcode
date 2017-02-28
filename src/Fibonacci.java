
/**
 * Created by thd on 2017/2/24.
 */
public class Fibonacci {
    public int Fibonaccirecursion(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        return (Fibonaccirecursion(n-1) +Fibonaccirecursion(n-2));
    }

    public int Fibonacciloop(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        int sum = 0;
        int f1 = 0;
        int f2 =1;
        for(int i = 1; i < n;i++){
            sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }
        return sum;
    }

    public static void main(String[] args){
        Fibonacci fb = new Fibonacci();
        System.out.println(fb.Fibonaccirecursion(30));
        System.out.println(fb.Fibonacciloop(30));
    }
}

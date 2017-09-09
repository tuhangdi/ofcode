/**
 * Created by thd on 2017/9/7.
 */
public class test2 {
    public static test2 t1 = new test2();
    public static test2 t2 = new test2();
    {
        System.out.println("构造块");
    }
    static
    {
        System.out.println("静态块");
    }
    public static void main(String[] args)
    {
        test2 t = new test2();
    }
}

/**
 * Created by thd on 2017/9/7.
 */
import java.util.*;

public class test2  {
    public test2() {
        System.out.println("HikvisionA");
    }
    {
        System.out.println("HikA COde");
    }
    static {
        System.out.println("Stack A");
    }


}


 class hb extends test2 {
    public hb() {
        System.out.println("Hb");
    }
    {
        System.out.println("hb code");
    }
    static {
        System.out.println("static");
    }

    public static void main(String[] args) {
        new hb();
        System.out.println(5&6);
    }
}
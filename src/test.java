
/**
 * Created by thd on 2017/8/9
 */
class Thread1 implements Runnable{
    private final String name;

    public Thread1(String name) {
        this.name = name;
    }
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行" + i);
        }
    }
}
public class test {
    public static void main(String[] args) {
        Thread1 th = new Thread1("A");
        Thread1 th2 = new Thread1("B");
        new Thread(th).start();
        new Thread(th2).start();
    }
}

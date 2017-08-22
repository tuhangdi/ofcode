import java.util.Arrays;
import java.util.Collection;

/**
 * Created by thd on 2017/8/21
 */
public class ABBA {
    public String canObtain(String in, String out) {
        if (in == null || out == null) return "Impossible";
        while (in.length() != out.length()) {
            if (out.charAt(out.length() - 1) == 'A')
                out = out.substring(0,out.length() - 1);
            else {
                out = out.substring(0,out.length() - 1);
                StringBuffer sb = new StringBuffer(out);
                sb.reverse();
                out = sb.toString();
            }
        }
        if (in.equals(out))
            return "Possible";
        return "Impossible";
    }

    public static void main(String[] args) {
        ABBA n = new ABBA();
        System.out.println(n.canObtain("B", "ABBA"));
        System.out.println(n.canObtain("BBAB", "ABABABABB"));
    }
}

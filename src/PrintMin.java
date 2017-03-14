import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by thd on 2017/3/9.
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组 {3，32，321}，则打印出这三个数字能排成的最小数字为 321323。
 */
public class PrintMin {
    public String PrintMinNumber(int [] numbers) {
        if (numbers.length == 0 || numbers == null) return "";
        String [] str = new String[numbers.length];
        StringBuffer print = new StringBuffer();
        for(int i = 0; i < numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, new Comparator<String>() {//重写sort的比较器
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });
        for(int i = 0; i < numbers.length; i++){
            print.append(str[i]);
        }
        return print.toString();
    }
}

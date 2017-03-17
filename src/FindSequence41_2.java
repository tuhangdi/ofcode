import java.util.ArrayList;

/**
 * Created by thd on 2017/3/17.
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class FindSequence41_2 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> allSequence = new ArrayList<ArrayList<Integer>>();
        if (sum <= 1) return allSequence;
        int small = 1;
        int big = 2;
        int middle = (1 + sum) / 2;
        while (small < middle){
            int curSum = small;
            for(int i = small + 1; i <= big; i ++) {
                curSum += i;
            }
            if (curSum == sum) {
                ArrayList<Integer> sequence = new ArrayList<Integer>();
                for (int i = small; i <= big; i ++)
                    sequence.add(i);
                allSequence.add(sequence);
                small ++;
                big ++;
            }
            else if (curSum < sum)
                big ++;
            else
                small ++;
        }
        return allSequence;
    }
}

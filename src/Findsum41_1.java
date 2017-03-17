import java.util.ArrayList;

/**
 * Created by thd on 2017/3/17.
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，输出任意一对即可。
 */
public class Findsum41_1 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum){
        int behind = 0;
        int find = 0;
        int ahead = array.length - 1;
        ArrayList<Integer> findsum = new ArrayList<>();
        while (ahead > behind){
            int curSum = array[ahead] + array[behind];
            if(curSum == sum){
                find = 1;
                findsum.add(array[behind]);
                findsum.add(array[ahead]);
                break;//找到
            }
            else if(curSum < sum)
                behind ++;
            else
                ahead --;
        }
        return findsum;
    }
}

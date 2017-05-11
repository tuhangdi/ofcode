/**
 * Created by thd on 2017/3/20.
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 */
public class SumofN43 {
    //递归做法
    public void PrintProbability(int num){
        int [] ptobabilityArray = new int [num * 6 - num + 1];
        for (int i = 1; i <= 6; i++) {
            Probability(num, num, i, ptobabilityArray);
        }
        int total = (int)Math.pow((double)6, (double)num);
        for (int i = num; i <= (6 * num); i++){
            double ratio = (double) ptobabilityArray[i - num] / total;
            System.out.println(ratio);
        }
    }
    private int[] Probability(int original, int current, int sum, int [] arrays){
        if(current == 1) {
            arrays[sum - original] ++;
        }
        else {
            for (int i = 1; i <= 6; i ++){
                Probability(original, current - 1, i + sum, arrays);
            }
        }
        return arrays;
    }
    public static void main(String[] args){
        SumofN43 sn = new SumofN43();
        sn.PrintProbability(5);
    }
}

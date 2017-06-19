package leetcode.Array;

/**
 * Created by thd on 2017/6/19.
 * In LLP world, there is a hero called Teemo and his attacking can make his enemy Ashe be in poisoned condition. Now, given the Teemo's attacking ascending time series towards Ashe and the poisoning time duration per Teemo's attacking, you need to output the total time that Ashe is in poisoned condition.
 考虑到Teemo对阿什的攻击上升时间序列和Teemo进攻的中毒时间，您需要输出阿什处于中毒状态的总时间。

 You may assume that Teemo attacks at the very beginning of a specific time point, and makes Ashe be in poisoned condition immediately.
 您可以假定Teemo在特定时间点的开始时发生攻击，并使Ashe立即处于中毒状态。

 Example 1:
 Input: [1,4], 2
 Output: 4
 Explanation: At time point 1, Teemo starts attacking Ashe and makes Ashe be poisoned immediately.
 This poisoned status will last 2 seconds until the end of time point 2.
 And at time point 4, Teemo attacks Ashe again, and causes Ashe to be in poisoned status for another 2 seconds.
 So you finally need to output 4.

 Example 2:
 Input: [1,2], 2
 Output: 3
 Explanation: At time point 1, Teemo starts attacking Ashe and makes Ashe be poisoned.
 This poisoned status will last 2 seconds until the end of time point 2.
 However, at the beginning of time point 2, Teemo attacks Ashe again who is already in poisoned status.
 Since the poisoned status won't add up together, though the second poisoning attack will still work at time point 2, it will stop at the end of time point 3.
 So you finally need to output 3.

 */
public class n495TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        int res = duration;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            int x = timeSeries[i+1] - timeSeries[i];
            if (x >= duration) res += duration;
            else res += x;
        }
        return res;
    }

    public static void main(String[] args) {
        n495TeemoAttacking n = new n495TeemoAttacking();
        int[] timeSeries = {1};
        int duration = 2;
        System.out.println(n.findPoisonedDuration(timeSeries, duration));
    }
}


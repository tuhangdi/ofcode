package leetcode.Array;




import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * Created by thd on 2017/8/21
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 给定一个未排序的整数数组，找出最长连续元素序列的长度。
 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 连续元数最长的序列是[1,2,3,4]。 返回长度：4。
 Your algorithm should run in O(n) complexity.


 我们将使用HashMap。关键是跟踪序列长度并将其存储在序列的边界点。例如，因此，对于序列{1,2,3,4,5}，map.get（1）和map.get（5）都应返回5。

 每当一个新的元素n被插入到map中，做两件事情：

 1. 看map中是否存在n-1和n + 1，如果是，则表示在n旁边有一个现有的序列。变量left和right将是这两个序列的长度，而0意味着没有序列和n作为边界点。存储（left+right+ 1）作为n的key存到map中。
 2. 使用left和right去分别定位n的其他序列的左右边界，并用新值替换长度。


 */
public class n128LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;

                int sum = left + right + 1;
                map.put(n, sum);

                res = Math.max(res, sum);

                map.put(n - left, sum);
                map.put(n + right, sum);
            }
            else {
                continue;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
}

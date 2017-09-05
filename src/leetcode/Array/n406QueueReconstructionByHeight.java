package leetcode.Array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by thd on 2017/9/4
 *
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 假设你有一个随机的人员排在队列中。 每个人由一对整数（h，k）描述，其中h是人的高度，k是具有高度大于或等于h的这个人面前的人数。 编写一个算法来重构队列。
 Note:
 The number of people is less than 1,100.

 Example

 Input:
 [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

 Output:
 [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]


 我们首先把人们从最高到最低的位置排序。 对于身高相同的人，根据他们之间的人数从小到大排列。

 然后，我们使用类似于插入排序来重新排列人的方式。
 对于一个要插入的人来说，所有已经排序的人都比较高，所以我们只是将他插入“正确的”地方，使在他之前的人数是他的“计数”。
 由于他比排序清单中的所有人都低，“现有”人的“计数”不会被插入。


 */
public class n406QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0)
            return new int[0][0];
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0] == o1[0]) return o1[1] - o2[1];
                return o2[0] - o1[0];

            }
        });

        int n = people.length;
        ArrayList<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});//将前面的人数作为ｉｎｄｅｘ插入到ｌｉｓｔ中，且由于ｐｅｏｐｌｅ是从大到小排的，因此小的值会后出现从而被插到前面
        }
        int[][] res = new int[people.length][2];
        int i = 0;
        for (int[] k : tmp) {
            res[i][0] = k[0];
            res[i++][1] = k[1];
        }
        return res;
    }

    @Test
    public void test() {
        int[][] n = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        System.out.println(reconstructQueue(n));
    }
}

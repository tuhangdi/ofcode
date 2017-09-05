package leetcode.Array;

import java.util.*;

/**
 * Created by thd on 2017/9/4
 *
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 给出一个代表CPU需要做的任务的char数组。 它包含大写字母A到Z，其中不同的字母表示不同的任务。
 任务可以在没有原始顺序的情况下完成。 每个任务可以在一个时间间隔内完成。 对于每个间隔，CPU可以完成一个任务或只是空闲。
 However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

 然而，存在非负的冷却间隔n，这意味着在两个相同的任务之间，CPU至少必须有n个间隔来执行不同的任务或只是空闲。

 You need to return the least number of intervals the CPU will take to finish all the given tasks.

 您需要返回CPU将完成所有给定任务所需的最少间隔时间。
 Example 1:
 Input: tasks = ['A','A','A','B','B','B'], n = 2
 Output: 8
 Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 Note:
 The number of tasks is in the range [1, 10000].
 The integer n is in the range [0, 100].


 要再次处理相同的任务，CPU不得不等待时间n，所以我们可以想象，如果有一个循环，时间n + 1，无论你是否在循环中安排一些其他任务。
 为了避免CPU有限的任务选择和不得不坐在那里频繁冷却，最重要的是保持任务池的多样性尽可能长。
 为了做到这一点，我们应该尽量安排CPU随时在最受欢迎的任务之间尝试循环。

 */
public class n621TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char t : tasks) {
            if (counts.containsKey(t))
                counts.put(t, counts.get(t) + 1);
            else
                counts.put(t, 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        pq.addAll(counts.values());

        int alltime = 0;
        int cycle = n + 1;
        while (!pq.isEmpty()) {
            int worktime = 0;
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < cycle; i++) {
                if (!pq.isEmpty()) {
                    tmp.add(pq.poll());
                    worktime++;
                }
            }
            for (int cnt : tmp) {
                if (--cnt > 0) {
                    pq.offer(cnt);
                }
            }
            alltime += !pq.isEmpty() ? cycle : worktime;
        }

        return alltime;
    }
}

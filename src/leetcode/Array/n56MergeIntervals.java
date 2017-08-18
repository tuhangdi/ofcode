package leetcode.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by thd on 2017/6/19.
 * Given a collection of intervals, merge all overlapping intervals.
 给定一个间隔集合，合并所有重叠的间隔。
 For example,
 Given [1,3],[2,6],[8,10],[15,18],
 return [1,6],[8,10],[15,18].

 先按start排序，然后遍历比较end。
 */
public class n56MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals.size() == 0) return res;
        Collections.sort(intervals, Comparator.comparingInt(o -> o.start));
        Interval f = intervals.get(0),tmp;

        for (int i = 1; i < intervals.size(); i++) {
            tmp = intervals.get(i);
            if (f.end >= tmp.start){
                f.end = Math.max(f.end, tmp.end);
            }
            else {
                res.add(f);
                f = tmp;
            }
        }
        res.add(f);
        return res;
    }
}

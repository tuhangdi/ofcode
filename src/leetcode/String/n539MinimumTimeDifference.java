package leetcode.String;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by thd on 2017/6/29.
 * Given a list of 24-hour clock time points in "Hour:Minutes" format,
 * find the minimum minutes difference between any two time points in the list.
 * Example 1:
 Input: ["23:59","00:00"]
 Output: 1
 *
 */
public class n539MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> time = new ArrayList<>();
        for (int i = 0; i < timePoints.size(); i++) {
            String[] str = timePoints.get(i).split(":");
            int h = Integer.valueOf(str[0]);
            int m = Integer.valueOf(str[1]);
            time.add(h * 60 + m);
        }
        Collections.sort(time);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < timePoints.size(); i++) {
            int tim = Math.min(Math.abs(time.get(i) - time.get(i-1)), 1440 - Math.abs(time.get(i) - time.get(i-1)));
            if (tim < min)
                min = tim;
        }
        int tim = Math.min(Math.abs(time.get(0) - time.get(timePoints.size()-1)), 1440 - Math.abs(time.get(0) - time.get(timePoints.size()-1)));
        if (tim < min)
            min = tim;

        return min;
    }

    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>();
        timePoints.add("23:59");
        timePoints.add("00:00");
        n539MinimumTimeDifference n = new n539MinimumTimeDifference();
        System.out.println(n.findMinDifference(timePoints));
    }
}

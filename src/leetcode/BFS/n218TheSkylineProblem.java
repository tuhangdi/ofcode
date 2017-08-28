package leetcode.BFS;

import java.util.*;

/**
 * Created by thd on 2017/8/28
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).
 * 一个城市的天际线是从远处观看的那个城市所有建筑物形成的轮廓的外部轮廓。 现在假设你给出了所有建筑物的位置和高度，如城市照片（图A）所示，写一个程序来输出由这些建筑物组成的天际线（图B）。
 *
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 每个建筑物的几何信息由三重整数[Li，Ri，Hi]表示，其中Li和Ri分别是第i栋建筑物左右边缘的x坐标，Hi是其高度。可以保证0≤Li，Ri≤Int_MAX，0 <height≤INT_MAX，Ri-Li> 0。您可以假设所有建筑物都是在高度为0的绝对平坦的表面上接地的完美矩形。
 For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 例如，图A中所有建筑物的尺寸记录为：[[2 9 10]，[3 7 15]，[5 12 12]，[15 20 10]，[19 24 8]]。
 The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
 输出是唯一定义天际线的[[x1，y1]，[x2，y2]，[x3，y3]，...]格式的“关键点”（图B中的红点）的列表。关键点是水平线段的左端点。请注意，最右边的建筑结束的最后一个关键点只是用于标记天际线的终止，并且总是具有零高度。此外，任何两个相邻建筑物之间的地面应被视为天际线轮廓的一部分。
 For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 例如，图B中的天际线应该表示为：[[2 10]，[3 15]，[7 12]，[12 0]，[15 10]，[20 8]，[24，0]] 。
 Notes:

 The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 The input list is already sorted in ascending order by the left x position Li.
 The output list must be sorted by the x position.
 There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]

我们需要实现的目标：
 1.按顺序访问所有起点和所有终点;
 2.访问点时，我们需要知道它是一个起点还是一个终点，基于此，我们可以添加高度或删除高度;

 为了实现这一点，他的实现：

    1.使用int [] []来为每栋建筑物收集所有[起点， - 高度]和[终点，高度]
       
    2.排序，首先基于第一个值，然后使用第二个区分;

 从而，

    1. 我们可以按顺序访问所有点;
    2. 当点具有相同的值时，较高的高度会影响较低的高度;
    3. 基于其高度的标志，我们可以知道当前点是起点还是终点;
 */
public class n218TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] b : buildings) {
            //起点具有负高度值
            height.add(new int[]{b[0], -b[2]});
            //终点具有正常高度值
            height.add(new int[]{b[1], b[2]});
        }

        //使用第一个值对height进行排序，如果有必要，用第二个值来区分
        Collections.sort(height, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        //使用大顶堆来存储可能的高度
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        //提供初始值以使其更加一致
        pq.offer(0);

        //开始前，先前最大height设为0
        int prev = 0;

        //访问排序后的所有点
        for(int[] h : height) {
            if (h[1] < 0) {//一个起点，加height
                pq.offer(-h[1]);
            } else {      //一个终点，移除height
                pq.remove(h[1]);
            }
            int cur = pq.peek(); //当前最大height

            //将当前最大height与以前的最大height进行比较，如果需要，更新result和以前的最大height
            if (prev != cur){
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }
}

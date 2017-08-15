package leetcode.Array;

/**
 * Created by thd on 2017/8/15
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 给定n个非负整数a1，a2，...，an，其中每个表示坐标（i，ai）处的点。
 绘制n条垂直线，使得线i的两个端点在（i，ai）和（i，0）处。
 找到两条线，它们与x轴一起形成一个容器，使得容器含有最多的水。

 Note: You may not slant the container and n is at least 2.
 */
public class n11ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}

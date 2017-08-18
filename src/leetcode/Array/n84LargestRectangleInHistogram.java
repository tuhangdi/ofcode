package leetcode.Array;

import java.util.Stack;

/**
 * Created by thd on 2017/8/18
 * 给定表示每个条的宽度为1的直方图条高的n个非负整数，找到直方图中最大矩形的面积。
 *
 *
 *
 * 单调栈
 */
public class n84LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        int max_area = 0;
        int tp; //保存栈顶
        int area_with_top; //保存最高bar作为最小bar的面积
        int i = 0;
        while (i < heights.length) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i])
                stack.push(i++);

            else {
                tp = stack.pop();

                area_with_top = heights[tp] * (stack.isEmpty() ? i : i - stack.peek() - 1); //计算以hegights[tp]作为最小bar的面积

                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }

        while (!stack.isEmpty()) { //计算仍然在栈中的每个bar作为最小bar的面积
            tp = stack.pop();
            area_with_top = heights[tp] * (stack.isEmpty() ? i : i - stack.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }
        return max_area;
    }
}

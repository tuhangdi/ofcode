package leetcode.DP;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by thd on 2017/8/18
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 Return 6.


 dp

 */
public class n85MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        int[] height = new int[n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            int curLeft = 0, curRight = n;
            for (int j = 0; j < n; j++) { //计算高度
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }

            for (int j = 0; j < n; j++) { //计算左边界，需要考虑上面几排的左边界
                if (matrix[i][j] == '1') left[j] = Math.max(left[j], curLeft);
                else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }

            for (int j = n - 1; j >= 0; j--) {//计算右边界，需要考虑上面几排的右边界
                if (matrix[i][j] == '1') right[j] = Math.min(right[j], curRight);
                else {
                    right[j] = n;
                    curRight = j;
                }
            }

            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
            }
        }
        return maxArea;
    }



    //左神，类似直方图 84题，单调栈
    public int maxRecSize(char[][] matrix) {
        if (matrix ==null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int maxArea = 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                height[j] = matrix[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxRecFromBottom(height), maxArea);
        }
        return maxArea;
    }

    public int maxRecFromBottom(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }
}

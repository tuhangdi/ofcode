package leetcode.Array;

import java.util.Stack;

/**
 * Created by thd on 2017/8/17
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.

 For example,
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

 这道题的要求是计算最多能装多少水。其中，数组中的数字表示高度。

 这道题的思路是采用l和r两个指针，维护装水两边的位置。

 当l处高度低时，说明l右侧装的水肯定和l处一样高，此时逐步右移l，同是加上l处与右移后位置高度差（因为这里都能装水啊），直到再遇到同样高或者更高的位置。然后进行下一轮判断。

 同样，当r处高度低时，说明r左侧的水肯定和r处一样高，此时逐步左移r，同是加上r处与左移后位置高度差，直到再遇到同样高或者更高的位置。

 最后直到l和r相遇，结束。

 */
public class n42TrappingRainWater {
    public int trap(int[] height) {
        int i = 0, j = height.length - 1;
        int max = 0, leftMax = 0, rightMax = 0;
        while (i <= j) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);
            if (leftMax < rightMax) {
                max += (leftMax - height[i]);
                i++;
            } else {
                max += (rightMax - height[j]);
                j--;
            }
        }
        return max;
    }
}

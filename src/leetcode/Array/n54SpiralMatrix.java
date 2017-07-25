package leetcode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thd on 2017/7/25
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]
 You should return [1,2,3,6,9,8,7,4,5].
 */
public class n54SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int left = 0, top = 0;
        int right = matrix[0].length - 1, down = matrix.length - 1;

        while (left <= right && top <= down){
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }
            top++;
            for (int i = top; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (top <= down) {
                for (int j = right; j >= left; j--) {
                    res.add(matrix[down][j]);
                }
            }
            down--;
            if (left <= right) {
                for (int i = down; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
            }
            left++;
        }
        return res;
    }
}

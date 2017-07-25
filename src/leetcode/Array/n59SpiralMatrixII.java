package leetcode.Array;

/**
 * Created by thd on 2017/7/25
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 给定一个整数n，生成一个填充有从1到n2的元素的方形矩阵。

 For example,
 Given n = 3,

 You should return the following matrix:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 */
public class n59SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int right = n - 1, down = n - 1;
        int left = 0, top = 0,count = 1;
        while (left <= right){
            for (int j = left; j <= right; j++) {
                res[top][j] = count;
                count++;
            }
            top++;
            for (int i = top; i <= down; i++) {
                res[i][right] = count;
                count++;
            }
            right--;
            for (int j = right; j >= left ; j--) {
                res[down][j] = count;
                count++;
            }
            down--;
            for (int i = down; i >= top; i--) {
                res[i][left] = count;
                count++;
            }
            left++;
        }
        return res;
    }
}

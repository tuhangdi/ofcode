package leetcode.Array;

/**
 * Created by thd on 2017/6/9.
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
 * 在MATLAB中，有一个非常有用的函数叫做“reshape”，它可以将矩阵重新形成一个不同大小但保持其原始数据的新矩阵。
 * You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
 * 给出一个由二维数组表示的矩阵，两个正整数r和c分别表示所需重组矩阵的行号和列号。
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
 * 重新组合的矩阵需要以与它们相同的行遍历顺序填充原始矩阵的所有元素。
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 * 如果具有给定参数的“reshape”操作是可行且合法的，则输出新的重构矩阵;否则，输出原始矩阵。
 * Example 1:
 * Input:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 1, c = 4
 * Output:
 * [[1,2,3,4]]
 * <p>
 * Explanation:
 * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
 * <p>
 * Example 2:
 * Input:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 2, c = 4
 * Output:
 * [[1,2],
 * [3,4]]
 * <p>
 * Explanation:
 * There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 */
public class n566ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r * c != nums.length * nums[0].length) return nums;
        int[][] newNums = new int[r][c];
        int [] temp = new int[r*c];
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                temp[k] = nums[i][j];
                k++;
            }
        }
        k = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                newNums[i][j] = temp[k];
                k++;
            }
        }
        return newNums;
    }

    public static void main(String[] args) {

    }
}

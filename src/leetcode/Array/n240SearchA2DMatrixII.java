package leetcode.Array;

/**
 * Created by thd on 2017/8/29
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 编写一个搜索m×n矩阵中的值的有效算法。 该矩阵具有以下属性：
 Integers in each row are sorted in ascending from left to right.
 Integers in each column are sorted in ascending from top to bottom.
 For example,
 每行的整数按从左到右的顺序进行排序。
 每列中的整数按照从上到下的顺序进行排序。
 例如，

 Consider the following matrix:

 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]

 Given target = 5, return true.

 Given target = 20, return false


 从右上角开始找，递归
 */
public class n240SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null) return false;
        int m = 0;
        int n = matrix[0].length - 1;
        return search(matrix, m, n, target);
    }

    public boolean search(int[][] matrix, int m, int n, int target) {
        if (m >matrix.length - 1 || n < 0) return false;
        if (matrix[m][n] == target) return true;
        if (matrix[m][n] > target) {
            return search(matrix, m, n - 1, target);
        } else {
            return search(matrix, m + 1, n, target);
        }
    }

    public static void main(String[] args) {
        int[][] num =  {{1, 4, 7, 11, 15},{2, 5, 8, 12, 19},{3, 6, 9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
        n240SearchA2DMatrixII n = new n240SearchA2DMatrixII();
        System.out.println(n.searchMatrix(num, 5));
    }
}

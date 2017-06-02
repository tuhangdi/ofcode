package leetcode.DP;

/**
 * Created by thd on 2017/6/1.
 *
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 * 数列如果由至少三个元素组成，并且任何两个连续元素之间的差异是相同的，则称为算术。

 For example, these are arithmetic sequence:

 1, 3, 5, 7, 9
 7, 7, 7, 7
 3, -1, -5, -9
 The following sequence is not arithmetic.

 1, 1, 2, 5, 7

 A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
 给出了由N个数字组成的零索引数组A. 该数组的切片是任何一对整数（P，Q），使得0 <= P <Q <N.
 A slice (P, Q) of array A is called arithmetic if the sequence:
 A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

 The function should return the number of arithmetic slices in the array A.
 该函数应该返回数组A中的算术切片数。

 Example:

 A = [1, 2, 3, 4]

 return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 */
public class n413ArtithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int add = 0;
        int count = 0;
        for (int i = 2; i < A.length; i++) {
            if(A[i] - A[i-1] == A[i-1] - A[i-2]){
                add ++;
                count += add;
            }
            else add = 0;
        }
        return count;
    }

    public static void main(String[] args) {
        int [] A = {1,2,3,8,9,10};
        n413ArtithmeticSlices a  = new n413ArtithmeticSlices();
        System.out.println(a.numberOfArithmeticSlices(A));
    }
}

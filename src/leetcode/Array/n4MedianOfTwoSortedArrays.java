package leetcode.Array;

/**
 * Created by thd on 2017/8/14
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
两个排序数组，nums1大小为m，nums2大小为n
 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
找到两个排序数组的中位数，O(log(m+n))
 Example 1:
 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5



 时间复杂度是O（log(m+n)）,思想与二分查找思想一样，每次可以去掉k/2的值， k = (m + n) / 2;
 该方法的核心是将原问题转换为一个寻找第k小数的问题，这样中位数实际上是第（m + n）/2小的数。因此本质问题是求解第k小数的问题。
 首先假设数组A和B的元素个数都大于k/2，我们比较A[k/2-1]和B[k/2-1]两个元素，这两个元素分别表示A的第k/2小的元素和B的第k/2小的元素。这两个元素比较共有三种情况：>、<和=。如果A[k/2-1]
 证明也很简单，可以采用反证法。假设A[k/2-1]大于合并之后的第k小值，我们不妨假定其为第（k+1）小值。由于A[k/2-1]小于B[k/2-1]，所以B[k/2-1]至少是第（k+2）小值。但实际上，在A中至多存在k/2-1个元素小于A[k/2-1]，B中也至多存在k/2-1个元素小于A[k/2-1]，所以小于A[k/2-1]的元素个数至多有k/2+ k/2-2，小于k，这与A[k/2-1]是第（k+1）的数矛盾。
 同理当A[k / 2 - 1] > B[k / 2 -1]时存在类似的结论
 当A[k / 2 - 1] = B[k / 2 -1]时，表示，在在A的k/2 -1之前已经有k/2 -1和数小于A[k / 2 -1]，同理在B 之前也是一样的，所以此时已经找到了第k小的数，即这个相等的元素
 */
public class n4MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;

    }
    public double getKth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) return B[bStart + k - 1];
        if (bStart > B.length - 1) return A[aStart + k - 1];
        if (k == 1) return Math.min(A[aStart], B[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k / 2 - 1 < A.length) aMid = A[aStart + k / 2 - 1];
        if (bStart + k / 2 - 1 < B.length) bMid = B[bStart + k / 2 - 1];

        if (aMid < bMid)
            return getKth(A, aStart + k / 2, B, bStart, k - k / 2);
        else
            return getKth(A, aStart, B, bStart + k / 2, k - k / 2);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4, 6};
        int[] nums2 = {3, 4, 7, 8};
        n4MedianOfTwoSortedArrays n = new n4MedianOfTwoSortedArrays();
        System.out.println(n.findMedianSortedArrays(nums1, nums2));
    }
}

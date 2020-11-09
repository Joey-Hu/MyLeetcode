package leetcode.twopointsAndslidewindow;

/**
 * @author: huhao
 * @time: 2020/11/9 8:30
 * @desc: https://leetcode.com/problems/merge-sorted-array/
 */
public class E88_MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        while (p >= 0) {
            while (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[p--] = nums1[i];
                    i--;
                }else {
                    nums1[p--] = nums2[j];
                    j--;
                }
            }

            while (i >= 0) {
                nums1[p--] = nums1[i--];
            }
            while (j >= 0) {
                nums1[p--] = nums2[j--];
            }
        }
    }
}

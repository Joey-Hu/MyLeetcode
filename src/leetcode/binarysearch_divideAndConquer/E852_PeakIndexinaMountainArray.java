package leetcode.binarysearch_divideAndConquer;

/**
 * @author: huhao
 * @time: 2020/9/30 15:33
 * @desc: https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */
public class E852_PeakIndexinaMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            if (arr[left] <= arr[right]) {
                left ++;
            }else {
                right --;;
            }
        }
        return left;
    }
}

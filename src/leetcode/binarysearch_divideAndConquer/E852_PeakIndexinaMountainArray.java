package leetcode.binarysearch_divideAndConquer;

/**
 * @author: huhao
 * @time: 2020/9/30 15:33
 * @desc: https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */
public class E852_PeakIndexinaMountainArray {


    /**
     * O(logN)
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray2(int[] arr) {
        int low = 0;
        int high = arr.length-1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= arr[mid+1]) {
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return low;

    }


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

package leetcode.binarysearch_divideAndConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/10/16 17:05
 * @desc: https://leetcode.com/problems/find-k-closest-elements/
 */
public class M658_FindKClosestElements {

    /**
     * 双指针
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - 1;
        while (high - low >= k) {
            if (Math.abs(arr[high] - x) >= Math.abs(arr[low] - x)) {
                high --;
            }else {
                low ++;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}

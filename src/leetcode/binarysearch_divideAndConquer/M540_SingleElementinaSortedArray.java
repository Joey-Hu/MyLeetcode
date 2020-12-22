package leetcode.binarysearch_divideAndConquer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/12/20 15:41
 * @desc: https://leetcode.com/problems/single-element-in-a-sorted-array/
 */
public class M540_SingleElementinaSortedArray {

    /**
     * binary search
     * @param nums
     * @return
     */
    public int singleNonDuplicate2(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid % 2 == 0) {
                // mid is even
                if (nums[mid] == nums[mid+1]) {
                    low = mid + 2;
                }else {
                    high = mid;
                }
            }else {
                // mid is odd
                if (nums[mid] == nums[mid-1]) {
                    low = mid + 1;
                }else {
                    high = mid;
                }
            }
        }
        return nums[low];

    }

        /**
         * hashMap
         * @param nums
         * @return
         */
    public int singleNonDuplicate(int[] nums) {
        Map<Integer, Integer> numFreq = new HashMap<>();
        int res = 0;

        for (int num : nums) {
            numFreq.put(num, numFreq.getOrDefault(num, 0) + 1);
        }

        for (Integer key : numFreq.keySet()) {
            if (numFreq.get(key) == 1) {
                res = key;
            }
        }
        return res;
    }
}

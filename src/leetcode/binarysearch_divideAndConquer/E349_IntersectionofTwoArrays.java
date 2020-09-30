package leetcode.binarysearch_divideAndConquer;

import java.util.*;

/**
 * @author: huhao
 * @time: 2020/9/30 16:43
 * @desc: https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class E349_IntersectionofTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        if (set1.size() > set2.size()) {
            int[] res = new int[set1.size()];
            int idx = 0;

            for (Integer integer : set1) {
                if (set2.contains(integer)) {
                    res[idx++] = integer;
                }
            }
            return  Arrays.copyOf(res, idx);
        }else {
            int[] res = new int[set2.size()];
            int idx = 0;

            for (Integer integer : set2) {
                if (set1.contains(integer)) {
                    res[idx++] = integer;
                }
            }
            return  Arrays.copyOf(res, idx);

        }
    }
}

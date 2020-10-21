package leetcode.binarysearch_divideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author: huhao
 * @time: 2020/10/19 16:18
 * @desc: https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class E350_IntersectionofTwoArraysII {

    /**
     * set
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();

        ArrayList<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for(int i=0, j=0; i<nums1.length && j<nums2.length;){
            if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                result.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] r = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            r[i] = result.get(i);
        }

        return r;
    }
}

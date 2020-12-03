package leetcode.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: huhao
 * @time: 2020/12/3 13:47
 * @desc: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 */
public class M373_FindKPairswithSmallestSums {

    /**
     * 最小堆
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((a, b) -> a.get(0)+a.get(1)-b.get(0)-b.get(1));
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return res;
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums1[i]);
                temp.add(nums2[j]);
                queue.offer(new ArrayList(temp));
            }
        }

        while (k>0) {
            List<Integer> temp = queue.poll();
            if (temp == null) {
                break;
            }
            res.add(temp);
            k--;
        }
        return res;
    }
}

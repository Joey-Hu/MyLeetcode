package LCCI;

import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/8/27 22:12
 * @desc: https://leetcode-cn.com/problems/smallest-difference-lcci/
 */
public class SmallestDifference {
    /**
     * 先排序，双指针从两个数组的头部向后扫描，哪个指针指向的元素小，该指针就向后移动
     * @param a
     * @param b
     * @return
     */
    public int smallestDifference(int[] a, int[] b) {

        Arrays.sort(a);
        Arrays.sort(b);

        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            min = (int)Math.min(min, Math.abs((long)a[i] - (long)b[j]));
            if (a[i] < b[j]) {
                i ++;
            }else {
                j ++;
            }
        }
        return min;
    }
}

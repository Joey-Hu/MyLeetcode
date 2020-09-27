package leetcode.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/27 19:17
 * @desc: https://leetcode.com/problems/pancake-sorting/
 */
public class M969_PancakeSorting {

    /**
     * 思路：arr元素为[1, 2, 3, ..., n]，我们先找到最大值n的位置k, 逆转数组的前k个数,此时最大值n位于数组的头部；
     * 然后逆转数组的前n个数，使最大值到无序区的尾部；
     * n-1同理
     * @param arr
     * @return
     */
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for (int x = arr.length, i; x > 0; --x) {
            for (i = 0; arr[i] != x; ++i);
            reverse(arr, i + 1);
            res.add(i + 1);
            reverse(arr, x);
            res.add(x);
        }
        return res;
    }

    private void reverse(int[] arr, int k) {
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,4,1};
        new M969_PancakeSorting().pancakeSort(arr);
    }
}

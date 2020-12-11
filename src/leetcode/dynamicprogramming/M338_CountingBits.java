package leetcode.dynamicprogramming;

import LCCI.DivingBoard;

import java.awt.print.Pageable;

/**
 * @author: huhao
 * @time: 2020/12/11 15:04
 * @desc: https://leetcode.com/problems/counting-bits/
 */
public class M338_CountingBits {

    /**
     * res[i] = res[n & (n-1)] + 1: 将 n 从右往左的第一个1变为0, 这样就能利用数组的已知元素，最后再把1加回来
     * @param num
     * @return
     */
    public int[] countBits2(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        for (int i = 1; i <= num; i++) {
            res[i] = res[i&(i-1)] + 1;
        }
        return res;
    }

    /**
     * 暴力解法：每个数逐次对2取余
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for (int i = 0; i <= num; i++) {
            res[i] = calOnes(i);
        }
        return res;
    }
    
    public int calOnes(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                count ++;
            }
            n = n / 2;
        }
        return count;
    }
    
    
}

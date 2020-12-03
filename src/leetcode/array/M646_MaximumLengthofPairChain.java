package leetcode.array;

import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/12/3 13:35
 * @desc: https://leetcode.com/problems/maximum-length-of-pair-chain/
 */
public class M646_MaximumLengthofPairChain {

    public int findLongestChain(int[][] pairs) {
        // 按照每个元组的结束元素排序
        Arrays.sort(pairs, (a, b) -> a[1]-b[1]);

        int count = 1;
        int end = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > end) {
                end = pairs[i][1];
                count++;
            }
        }
        return count;
    }
}

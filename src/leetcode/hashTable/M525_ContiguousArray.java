package leetcode.hashTable;

import sun.nio.cs.ext.MS874;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/10/20 10:17
 * @desc: https://leetcode.com/problems/contiguous-array/
 */
public class M525_ContiguousArray {

    /**
     * 累计和：遇到 1 ，sum++, 遇到 0 ，sum--
     * 使用 hashMap 记录每个 sum 值及其结尾下标，如果 sum 再次出现表示两个 sum 之间的 0 和 1 的数量是相等的
     * @param nums
     * @return
     */
    public int findMaxLength2(int[] nums) {
        int maxLength = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // 注意: 初始化 sum 第一次等于0时，下标等于-1
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i-map.get(sum));
            }else {
                map.put(sum, i);
            }
        }
        return maxLength;
    }


    /**
     * 题目的意思是求出最长子序列的长度，子序列要求 0 和 1 的数量相等
     * 双重循环 TLE !!!
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int zeroCount = 0;
            int oneCount = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    zeroCount ++;
                }else {
                    oneCount ++;
                }
                if (zeroCount == oneCount) {
                    maxLength = Math.max(maxLength, j-i+1);
                }
            }
        }
        return maxLength;
    }
}

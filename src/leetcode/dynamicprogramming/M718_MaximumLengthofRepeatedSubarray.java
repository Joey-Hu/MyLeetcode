package leetcode.dynamicprogramming;

/**
 * @author: huhao
 * @time: 2020/10/16 17:20
 * @desc: https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 */
public class M718_MaximumLengthofRepeatedSubarray {

    /**
     * DP
     * 类似于求解两字符串的最长子串(Longest Common Substring)
     * O(M * N)
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length+1][B.length+1];

        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else {
                    if (A[i-1] == B[j-1]) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                        max = Math.max(max, dp[i][j]);
                    }
                }

            }
        }
        return max;
    }
}

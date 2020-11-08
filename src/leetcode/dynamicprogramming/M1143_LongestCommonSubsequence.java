package leetcode.dynamicprogramming;

import LCCI.Maximum;

/**
 * @author: huhao
 * @time: 2020/9/8 20:48
 * @desc: https://leetcode.com/problems/longest-common-subsequence/
 */
public class M1143_LongestCommonSubsequence {

    /**
     * 第一遍不会
     * 参考：https://www.youtube.com/watch?v=NnD96abizww
     * https://leetcode.com/problems/longest-common-subsequence/discuss/348884/C%2B%2B-with-picture-O(nm)
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] matrix = new int[len1+1][len2+1];

        for (int i = 1; i <= text1.length(); i ++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                }else {
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }
        return matrix[len1][len2];
    }
}

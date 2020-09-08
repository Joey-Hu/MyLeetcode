package leetcode.dynamicprogramming;

/**
 * @author: huhao
 * @time: 2020/9/8 10:05
 * @desc: https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {

    /**
     * 动态规划
     * 第一遍不会
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        int len = s.length();
        String res = null;

        boolean[][] dp = new boolean[len][len];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;

    }
}

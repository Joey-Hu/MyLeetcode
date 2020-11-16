package leetcode.dynamicprogramming;

/**
 * @author: huhao
 * @time: 2020/9/8 10:05
 * @desc: https://leetcode.com/problems/longest-palindromic-substring/
 */
public class M5_LongestPalindromicSubstring {

    /**
     * 动态规划
     * dp[i][j] == 1 表示s[i...j]是回文串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        int len = s.length();
        String res = null;

        boolean[][] dp = new boolean[len][len];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 //  if window is less than or equal to 3, just end chars should match
                        || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    public String longestPalindrome2(String s) {
        String res = "";
        int maxLength = 0;
        for (int i = 0; i < s.length()-1; i++) {
            for (int j = i+1; j < s.length(); j++) {
                int left = i;
                int right = j;
                boolean isPalindrome = true;
                while (left <= right) {
                    if (s.charAt(left++) != s.charAt(right--)) {
                        isPalindrome = false;
                        break;
                    }
                }
                if (isPalindrome) {
                    if (j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        res = s.substring(i, j+1);
                    }
                }
            }
        }
        return res;
    }
}

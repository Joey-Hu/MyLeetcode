package leetcode.dynamicprogramming;

/**
 * @author: huhao
 * @time: 2020/9/9 19:25
 * @desc: https://leetcode.com/problems/regular-expression-matching/
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }

        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;

        for (int pi = 2; pi <= dp.length; pi++) {
            if (p.charAt(pi-1) == '*' && dp[0][pi-2]) {
                dp[0][pi] = true;
            }
        }

        return false;



    }
}

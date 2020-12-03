package nowcoder.meituan2020;

import java.util.Scanner;

/**
 * @author: huhao
 * @time: 2020/12/3 8:54
 * @desc: https://www.nowcoder.com/question/next?pid=21910764&qid=894511&tid=39793132
 */
public class p6 {

    public static boolean isMatch(String exp1, String exp2) {
        int m = exp1.length();
        int n = exp2.length();

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i-1] && exp2.charAt(i) == '*';
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (exp1.charAt(i-1) == exp2.charAt(j-1) || exp2.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                }
                if (exp2.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String p = sc.next();
        String s = sc.next();

        System.out.println(isMatch(p, s));
    }
}

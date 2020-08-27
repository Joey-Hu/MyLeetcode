package LCCI;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/8/24 15:26
 * @desc: https://leetcode-cn.com/problems/boolean-evaluation-lcci/
 */
public class BooleanEvaluation {


    /**
     * 区间动态规划
     * @param s
     * @param result
     * @return
     */
    public int countEval(String s, int result) {
        if (s == null) {
            return 0;
        }

        int n = s.length();
        int len = 0;
        int[][] dp0 = new int[n][n];
        int[][] dp1 = new int[n][n];

        //dp?[i][j] 表示 区间[i,j]内运算值为 ? 的方案数
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                dp1[i][i] = 1;
            }else {
                dp0[i][i] = 1;
            }
        }

        for (len = 2; len <= n-1; len += 2) {
            //按长度递增
            for (int i = 0; i < n - len; i += 2) {
                // 左端点i
                for (int j = i; j < i+len-2; j += 2) {
                    // 中间端点j
                    if(s.charAt(j+1)=='&')
                    {
                        dp1[i][i+len] += dp1[i][j]*dp1[j+2][i+len];
                        dp0[i][i+len] += dp0[i][j]*dp0[j+2][i+len]+dp1[i][j]*dp0[j+2][i+len]+dp0[i][j]*dp1[j+2][i+len];
                    }
                    else if(s.charAt(j+1)=='|')
                    {
                        dp1[i][i+len] += dp1[i][j]*dp1[j+2][i+len]+dp1[i][j]*dp0[j+2][i+len]+dp0[i][j]*dp1[j+2][i+len];
                        dp0[i][i+len] += dp0[i][j]*dp0[j+2][i+len];
                    }
                    else//^
                    {
                        dp1[i][i+len] += dp1[i][j]*dp0[j+2][i+len]+dp0[i][j]*dp1[j+2][i+len];
                        dp0[i][i+len] += dp0[i][j]*dp0[j+2][i+len]+dp1[i][j]*dp1[j+2][i+len];
                    }
                }
            }
        }
        if(result == 1) {
            return dp1[0][n-1];
        }
        return dp0[0][n-1];

    }

    public static void main(String[] args) {
        BooleanEvaluation booleanEvaluation = new BooleanEvaluation();
        System.out.println(booleanEvaluation.countEval("1^0|0|1", 0));
    }
}

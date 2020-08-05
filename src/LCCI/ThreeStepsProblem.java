package LCCI;

/**
 * @author: huhao
 * @time: 2020/8/5 16:35
 * @desc: https://leetcode-cn.com/problems/three-steps-problem-lcci/
 */
public class ThreeStepsProblem {
    public int waysToStep(int n) {

        // 动态规划
        // 要走第n阶时，可以由n-1阶上1阶，可以由n-2阶上2阶，可以由n-3阶上3阶而来，也就是前三次走法的和。
        long [] dp = new long[n+1];
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(n == 3){
            return 4;
        }
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for (int i=4; i<=n; i++){
            dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % 1000000007;
        }
        return (int)dp[n];
    }
}

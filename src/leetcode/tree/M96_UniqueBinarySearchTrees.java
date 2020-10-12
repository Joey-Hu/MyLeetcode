package leetcode.tree;

/**
 * @author: huhao
 * @time: 2020/10/12 14:50
 * @desc:https://leetcode.com/problems/unique-binary-search-trees/
 */
public class M96_UniqueBinarySearchTrees {
    /**
     * 卡塔兰数列
     * dp
     * @param n
     * @return
     */
    public int numTrees(int n) {

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}

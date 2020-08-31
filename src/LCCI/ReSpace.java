package LCCI;

import java.util.*;

/**
 * @author: huhao
 * @time: 2020/8/31 19:11
 * @desc: https://leetcode-cn.com/problems/re-space-lcci/
 */
public class ReSpace {
    /**
     * 动态规划
     * dp[i] 表示字符串的前 i 个字符的最少未匹配数
     * 假设当前我们已经考虑完了前 i 个字符了，对于前 i + 1 个字符对应的最少未匹配数：
     *      1. 第 i + 1 个字符未匹配，则 dp[i + 1] = dp[i] + 1，即不匹配数加 1;
     *      2. 遍历前 i 个字符，若以其中某一个下标 idx 为开头、以第 i + 1 个字符为结尾的字符串正好在词典里，则 dp[i] = min(dp[i], dp[idx]) 更新 dp[i]。
     * O(n^2)
     * @param dictionary
     * @param sentence
     * @return
     */
    public int respace(String[] dictionary, String sentence) {

        // 转成散列表好用contains判断
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
        int n = sentence.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int idx = 0; idx < i; idx++) {
                if (dict.contains(sentence.substring(idx, i))) {
                    dp[i] = Math.min(dp[i], dp[idx]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String[] dictionary =  new String[]{"looked", "just", "like", "her", "brother"};
        String sentence = "jesslookedjustliketimherbrother";
        System.out.println(new ReSpace().respace(dictionary, sentence));
    }

}

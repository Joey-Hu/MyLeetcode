package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/9 20:15
 * @desc: https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

    /**
     * 当 "(" 的数量小于n时，添加 "("；当 "(" 的数量大于 ")" 时，添加")"
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<String>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    public void backtrack(List<String> res, String cur, int open, int close, int max) {
        // 结束条件
        if (cur.length() == max*2) {
            res.add(cur);
        }

        if (open < max) {
            backtrack(res, cur+"(", open+1, close, max);
        }
        if (open > close) {
            backtrack(res, cur+")", open, close+1, max);
        }
    }
}

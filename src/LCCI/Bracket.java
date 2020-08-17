package LCCI;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/8/17 15:25
 * @desc: https://leetcode-cn.com/problems/bracket-lcci/
 */
public class Bracket {
    /**
     * 回溯
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        if (n == 0){
            return new ArrayList<>(0);
        }
        List<String> res = new ArrayList<>();
        StringBuilder track = new StringBuilder();
        backtrack(n, n, res, track);
        return res;
    }

    private void backtrack(int left, int right, List<String> res, StringBuilder track) {
        // 若左括号数量大于右括号，不合法
        if (left > right){
            return;
        }
        // 若左括号数量或右括号数量小于0，不合法
        if (left < 0 || right < 0){
            return;
        }
        // 若左括号数量和右括号数量均为0，合法，加入res
        if (left == 0 && right == 0) {
            res.add(track.toString());
            return;
        }

        // 添加一个左括号
        track.append('(');
        backtrack(left-1, right, res, track);
        track.deleteCharAt(track.length()-1);

        // 添加一个右括号
        track.append(')');
        backtrack(left, right-1, res, track);
        track.deleteCharAt(track.length()-1);
    }

    public static void main(String[] args) {
        Bracket bracket = new Bracket();
        System.out.println(bracket.generateParenthesis(3));
    }
}

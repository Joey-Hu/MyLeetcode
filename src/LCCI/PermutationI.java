package LCCI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/8/13 20:37
 * @desc: https://leetcode-cn.com/problems/permutation-i-lcci/
 * 回溯法：可以把回溯法看成是递归调用的一种特殊形式，
 * 参考：https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie/hui-su-suan-fa-xiang-jie-xiu-ding-ban
 *  result = []
    def backtrack(路径, 选择列表):
        if 满足结束条件:
            result.add(路径)
            return

        for 选择 in 选择列表:
            做选择
            backtrack(路径, 选择列表)
            撤销选择
 */
public class PermutationI {
    /**
     * 回溯法
     * @param S
     * @return
     */
    List<String> list = new ArrayList<>();
    public String[] permutation(String S) {
        if (S == ""){
            return new String[0];
        }
        for(int i=0; i<S.length(); i++){
            StringBuilder sb = new StringBuilder();
            boolean[] vis = new boolean[S.length()];
            backtrack(sb, S, S.charAt(i), vis);
        }
        // 输出结果
        String[] res = new String[list.size()];
        for (int j=0; j<list.size(); j++) {
            res[j] = list.get(j);
        }
        return res;
    }

    private void backtrack(StringBuilder sb, String s, Character c, boolean[] vis) {
        sb.append(c);
        vis[s.indexOf(c)] = true;
        // 满足条件则添加排列结果
        if(sb.length() == s.length()){
            list.add(sb.toString());
            return;
        }
        // for 遍历
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!=c&&!vis[i]){
                backtrack(sb, s, s.charAt(i), vis);
                // 恢复 vis 和 sb
                vis[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        PermutationI permutationI = new PermutationI();
        System.out.println(Arrays.toString(permutationI.permutation("qwe")));

    }


}



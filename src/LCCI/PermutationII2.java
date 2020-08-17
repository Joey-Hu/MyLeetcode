package LCCI;

import java.util.*;

/**
 * @author: huhao
 * @time: 2020/8/16 15:21
 * @desc: https://leetcode-cn.com/problems/permutation-ii-lcci/
 */
public class PermutationII2 {
    /**
     * 回溯法
     * @param S
     * @return
     */
    Set<String> set = new HashSet<>();
    public String[] permutation(String S) {
        if (S == ""){
            return new String[0];
        }

        for (int i=0; i<S.length(); i++){
            StringBuilder sb = new StringBuilder();
            boolean[] vis = new boolean[S.length()];
            backtrack(sb, S, S.charAt(i), vis);
        }
        // 输出结果
        String[] res = set.toArray(new String[set.size()]);

        return res;

    }

    private void backtrack(StringBuilder sb, String s, char c, boolean[] vis) {

        // 触发结束条件
        if (sb.length() == s.length()){
            set.add(sb.toString());
            return;
        }
        for (int i=0; i<s.length(); i++){
            if(!vis[i]){
                sb.append(s.charAt(i));
                vis[i] = true;
                backtrack(sb, s, s.charAt(i), vis);
                vis[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        PermutationII2 permutationII2 = new PermutationII2();
        System.out.println(Arrays.toString(permutationII2.permutation("qqe")));
    }
}

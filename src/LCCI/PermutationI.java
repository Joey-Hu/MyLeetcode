package LCCI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/8/13 20:37
 * @desc: https://leetcode-cn.com/problems/permutation-i-lcci/
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
       String[] res = new String[list.size()];
       for (int j=0; j<list.size(); j++) {
           res[j] = list.get(j);
       }
       return res;
    }

    private void backtrack(StringBuilder sb, String s, Character c, boolean[] vis) {
        sb.append(c);
        vis[s.indexOf(c)] = true;
        if(sb.length() == s.length()){
            list.add(sb.toString());
            return;
        }
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



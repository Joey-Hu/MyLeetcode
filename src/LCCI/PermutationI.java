package LCCI;

import java.util.ArrayList;
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
    public String[] permutation(String S) {
        char[] chars = S.toCharArray();
        List<String> res = new ArrayList<>();
        backtrack(res, new ArrayList<String>(), chars, chars);

    }

    }


}

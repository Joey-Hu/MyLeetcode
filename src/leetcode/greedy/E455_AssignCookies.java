package leetcode.greedy;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/12/11 17:17
 * @desc: https://leetcode.com/problems/assign-cookies/
 */
public class E455_AssignCookies {

    /**
     * 因为是只能给每个孩子分一块，所以，直接排序逐队比较大小即可
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        int idxG = 0;
        int idxS = 0;
        while (idxG < g.length && idxS < s.length) {
            // 如果s[j]能满足g[i]，i++, j++；如果不能，j++
            if (g[idxG] <= s[idxS]) {
                count ++;
                idxG++;
            }
            idxS ++;
        }
        return count;
    }
}

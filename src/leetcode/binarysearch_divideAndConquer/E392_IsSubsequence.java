package leetcode.binarysearch_divideAndConquer;

/**
 * @author: huhao
 * @time: 2020/10/16 14:38
 * @desc: https://leetcode.com/problems/is-subsequence/
 */
public class E392_IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = getIndex(ch, t, start);
            if (idx == -1) {
                return false;
            }else {
                start = idx + 1;
            }
        }
        return true;
    }

    /**
     * 获取字符ch在字符串t中的索引位置
     * @param ch
     * @param t
     * @return
     */
    private int getIndex(char ch, String t, int start) {
        for (int i = start; i < t.length(); i++) {
            if (ch == t.charAt(i)) {
                return i;
            }
        }
        return -1;
    }
}

package leetcode.string;

/**
 * @author: huhao
 * @time: 2020/9/28 10:18
 * @desc: https://leetcode.com/problems/split-a-string-in-balanced-strings/
 */
public class E1221_SplitaStringinBalancedStrings {
    public int balancedStringSplit(String s) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count == 0) {
                res ++;
            }
            if (s.charAt(i) == 'L') {
                count ++;
            }
            if (s.charAt(i) == 'R') {
                count --;
            }
        }
        return res;
    }
}

package leetcode.string;

/**
 * @author: huhao
 * @time: 2020/9/29 10:07
 * @desc: https://leetcode.com/problems/bulb-switcher-iv/
 */
public class M1529_BulbSwitcherIV {

    /**
     * 如果字符与前一个字符不同，说明此处发生了flip
     * @param target
     * @return
     */
    public int minFlips(String target) {
        char prev = '0';
        int res = 0;

        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) != prev) {
                prev = target.charAt(i);
                res ++;
            }
        }
        return res;
    }
}

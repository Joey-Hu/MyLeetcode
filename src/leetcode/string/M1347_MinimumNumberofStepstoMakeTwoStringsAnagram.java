package leetcode.string;

/**
 * @author: huhao
 * @time: 2020/9/28 14:42
 * @desc: https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
 */
public class M1347_MinimumNumberofStepstoMakeTwoStringsAnagram {

    /**
     * 遍历字符串s，获得字符统计数组count
     * 遍历字符串t，如果count中含有该字符，数量减一，否则res++
     * @param s
     * @param t
     * @return
     */
    public int minSteps(String s, String t) {
        int[] count = new int[26];
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a'] ++;
        }

        for (int i = 0; i < t.length(); i++) {
            if (count[t.charAt(i)-'a'] > 0) {
                count[t.charAt(i)-'a'] --;
            } else {
                res ++;
            }
        }
        return res;
    }
}

package leetcode.greedy;

/**
 * @author: huhao
 * @time: 2020/9/25 20:13
 * @desc: https://leetcode.com/problems/remove-duplicate-letters/
 */
public class H316_RemoveDuplicateLetters {
    /**
     * 比较难
     * 贪心算法Greedy，用1个HashMap或者数组统计出现的字符。然后再遍历一遍数组,
     * 假设position = 0，每次找到字符比position的小就更新position，同时也更新count，当count[i] == 0的时候，
     * 这个字符就是我们要找的结果字符串里的第一个字符。之后因为其他字符的count还都 > 1，
     * 继续在s.substring(position + 1)的子串里递归查找第二个字符，注意要在这个子串里把第一个字符清除掉。
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a'] ++;
        }

        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(pos) > s.charAt(i)) {
                pos = i;
            }

            count[s.charAt(i)-'a'] --;
            // found first minimum char
            if (s.charAt(i) == 0) {
                break;
            }
        }

        String charToRemove = String.valueOf(s.charAt(pos));
        return charToRemove + removeDuplicateLetters(s.substring(pos + 1).replaceAll(charToRemove, ""));
    }
}

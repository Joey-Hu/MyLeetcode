package leetcode.twopointsAndslidewindow;

/**
 * @author: huhao
 * @time: 2020/9/14 20:28
 * @desc: https://leetcode.com/problems/minimum-window-substring/
 * SimilarQuestion：567. Permutation in String
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
       int[] map = new int[128];
       for (char c : t.toCharArray()) {
           map[c]++;
       }

       int start = 0;
       int end = 0;
       int minStart = 0;
       int minLen = Integer.MAX_VALUE;
       int counter = t.length();

       // 当start和end之间不包含t所有字符时，end 向后移
       while (end < s.length()) {
           char c1 = s.charAt(end);
           if (map[c1] > 0) {
               counter --;
           }
           map[c1] --;
           end ++;
           // 当start和end之间正好包含t所有字符时（end一定在t的某个字符上），start向前移，跳出循环
           while (counter == 0) {
               if (minLen > end - start) {
                   minLen = end - start;
                   minStart = start;
               }
               char c2 = s.charAt(start);
               map[c2] ++;
               if (map[c2] > 0) {
                   counter ++;
               }
               start ++;
           }
       }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC");
    }


}

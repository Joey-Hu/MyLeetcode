package leetcode.string;

import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/9/29 14:25
 * @desc: https://leetcode.com/problems/check-if-a-string-can-break-another-string/
 */
public class M1433_CheckIfaStringCanBreakAnotherString {

    public boolean checkIfCanBreak(String s1, String s2) {
        char[] chA = s1.toCharArray();
        char[] chB = s2.toCharArray();

        int index = 0;
        Arrays.sort(chA);
        Arrays.sort(chB);
        // 晒去前面相同的字符，直到chA[index] != chB[index]
        while (chA[index] == chB[index]) {
            index++;
        }
        // index == s1.length()表示s1和s2所有字符都相同，符合条件，返回true
        if (index == s1.length()) {
            return true;
        }

        boolean temp = chA[index] > chB[index];
        while (index < s1.length()) {
            // 如果两字符相同，符合条件，下一个字符
            if(chA[index] == chB[index]) {
                index ++;
                continue;
            }
            // 如果两字符的关系变得和前面不一样了，返回false
            if ((chA[index] > chB[index]) != temp) {
                return false;
            }
            index ++;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "xya";
        new M1433_CheckIfaStringCanBreakAnotherString().checkIfCanBreak(s1, s2);
    }
}

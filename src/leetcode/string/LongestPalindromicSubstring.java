import javax.naming.ldap.ExtendedRequest;
import java.awt.*;

/**
 * @author: huhao
 * @time: 2020/9/11 17:10
 * @desc:
 */
public class LongestPalindromicSubstring {

    private int low;
    private int maxLen;


    public String longestPalindrome(String s) {
        if (s.length() <= 1){
            return s;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            // 奇数长度
            extendPalindrome(s, i, i);
            // 偶数长度
            extendPalindrome(s, i, i+1);

        }
        return s.substring(low, low + maxLen);
    }

    private void extendPalindrome(String s, int i, int j) {
        while (i >=0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i --;
            j ++;
        }

        // 上面 while 循环结束时，i和j都往外扩了一个, 所以长度应为 j - i - 1，low 应为 i + 1
        if (j - i - 1 > maxLen) {
            low = i + 1;
            maxLen = j - i - 1;
        }
    }

}

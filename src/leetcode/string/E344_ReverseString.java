package leetcode.string;

/**
 * @author: huhao
 * @time: 2020/11/9 19:52
 * @desc: https://leetcode.com/problems/reverse-string/
 */
public class E344_ReverseString {

    public void reverseString(char[] s) {
        int low = 0;
        int high = s.length - 1;
        while (low < high) {
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low ++;
            high --;
        }
    }
}

package leetcode.number;

/**
 * @author: huhao
 * @time: 2020/9/4 14:02
 * @desc: https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber2 {

    /**
     * 逆转（不考虑边界）
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {

        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }

        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }

        return (x == rev || x == rev / 10);
    }

    public static void main(String[] args) {
        new PalindromeNumber2().isPalindrome(10);
    }
}

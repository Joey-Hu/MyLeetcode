package leetcode.twopointsAndslidewindow;

/**
 * @author: huhao
 * @time: 2020/12/14 19:27
 * @desc: https://leetcode.com/problems/valid-palindrome-ii/
 */
public class E680_ValidPalindromeII {

    /**
     * 由于题目条件的设置，最多只能删除一个字符，所以当遇到s[low] != s[high]时，只要判定s[low+1,high]或s[low, high-1]是否是回文即可
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {

        char[] sCharArray = s.toCharArray();
        int low = 0;
        int high = s.length()-1;

        while (low <= high) {
            if (sCharArray[low] == sCharArray[high]) {
                low ++;
                high --;
            }else {
                return isPalindrome(sCharArray, low, high-1) || isPalindrome(sCharArray, low+1, high);
            }
        }
        return true;
    }

    private boolean isPalindrome(char[] sCharArray, int low, int high) {
        while (low <= high) {
            if (sCharArray[low] == sCharArray[high]) {
                low ++;
                high --;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new E680_ValidPalindromeII().validPalindrome("ebcbbececabbacecbbcbe");
    }
}

package leetcode;

import java.util.ArrayList;

/**
 * @author: huhao
 * @time: 2020/9/4 14:02
 * @desc: https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {

    /**
     * 逆转（考虑边界）
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        int x1 = x;
        while (x1 > 0) {
            arrayList.add(x1 % 10);
            x1 = x1 / 10;
        }

        int res = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (res * 10 >= Integer.MAX_VALUE) {
                return false;
            } else {
                res = res * 10 + arrayList.get(i);
            }
        }

        return res == x;
    }

    public static void main(String[] args) {
        new PalindromeNumber().isPalindrome(10);
    }
}

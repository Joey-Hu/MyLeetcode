package leetcode.string;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: huhao
 * @time: 2020/11/9 21:04
 * @desc: https://leetcode.com/problems/add-strings/
 */
public class E415_AddStrings {

    public String addStrings(String num1, String num2) {
        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;
        StringBuilder res = new StringBuilder();
        int carry = 0;
        while (idx1 >= 0 || idx2 >= 0 || carry != 0) {
            int sum = 0;
            if (idx1 >= 0) {
                int n1 = num1.charAt(idx1) - '0';
                sum += n1;
            }
            if (idx2 >= 0) {
                int n2 = num2.charAt(idx2) - '0';
                sum += n2;
            }

            char sum2 = (char)((sum + carry) % 10 + '0') ;
            res.insert(0, sum2);
            carry = (sum + carry) / 10;
            idx1 --;
            idx2 --;

        }

        return res.toString();
    }

    public static void main(String[] args) {
        new E415_AddStrings().addStrings ("1", "99");
    }
}

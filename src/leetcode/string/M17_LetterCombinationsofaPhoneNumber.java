package leetcode.string;

import com.sun.org.apache.regexp.internal.REUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/29 16:28
 * @desc: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class M17_LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits.length() == 0) {
            return res;
        }

        String[] phoneNumber = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        addLetters(res, phoneNumber, digits, 0, "");

        return res;
    }

    private void addLetters(List<String> res, String[] phoneNumber, String digits, int level, String s) {
        // S长度已经和digits长度一致，则将s加入到res中
        if (level == digits.length()) {
            res.add(s);
            // 返回上一层
            return;
        }

        char ch = digits.charAt(level);
        String letters = phoneNumber[ch - '0'];
        for (int i = 0; i < letters.length(); i++) {
            // 递归调用，进入下一层
            addLetters(res, phoneNumber, digits, level+1, s+letters.charAt(i));
        }
        return;
    }

}

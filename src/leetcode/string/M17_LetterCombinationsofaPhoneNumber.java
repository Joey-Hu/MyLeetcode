package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/29 16:28
 * @desc: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class M17_LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {
        char[][] map = new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        List<String> res = new ArrayList<>();
        backtrack(map, digits, new ArrayList<Character>(), res);



    }

    private void backtrack(char[][] map, String digits, ArrayList<Character> characters, List<String> res) {
        if (characters.size() == digits.length()) {
            res.add(characters.toString());
        }

        for (int i = 0; i < digits.length(); i++) {

        }
    }
}

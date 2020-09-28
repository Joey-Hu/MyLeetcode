package leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: huhao
 * @time: 2020/9/28 10:31
 * @desc: https://leetcode.com/problems/unique-morse-code-words/
 */
public class E804_UniqueMorseCodeWords {

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> morseCodeSet = new HashSet<>();
        String[] code = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        for (String word : words) {
            String mCode = "";
            for (int i = 0; i < word.length(); i++) {
                mCode += code[word.charAt(i) - 'a'];
            }
            morseCodeSet.add(mCode);
        }
        return morseCodeSet.size();
    }
}

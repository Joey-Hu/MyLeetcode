package leetcode.string;

/**
 * @author: huhao
 * @time: 2020/9/29 15:03
 * @desc: https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
 */
public class E1455_CheckIfaWordOccursAsaPrefixofAnyWordinaSentence {


    public int isPrefixOfWord(String sentence, String searchWord) {
        // 记录单词位置
        int indexOfWord = 1;
        // 获得sentence中单词的长度，获取子字符串，与searchaWord进行匹配
        for (int i = 0; i < sentence.length(); i++) {
            int j = i;
            while (j + 1 < sentence.length() && sentence.charAt(j+1) != ' ') {
                j++;
            }
            // 如果匹配，就返回单词位置
            if (isMatch(sentence, searchWord, i, j)){
                return indexOfWord;
            }else {  // 否则，进行下一个单词匹配
                i = j + 1;
                indexOfWord ++;
            }
        }
        return -1;
    }

    private boolean isMatch(String sentence, String searchWord, int start, int end) {

        String subStr = sentence.substring(start, end+1);
        if (subStr.length() < searchWord.length()) {
            return false;
        }
        int i = 0;
        while (i < searchWord.length()) {
            if (subStr.charAt(i) != searchWord.charAt(i)) {
                return false;
            }
            i++;
        }
        return true;
    }
}

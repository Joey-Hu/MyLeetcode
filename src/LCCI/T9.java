package LCCI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/8/19 10:28
 * @desc: https://leetcode-cn.com/problems/t9-lcci/submissions/
 */
public class T9 {
    /**
     * map方法 匹配
     * 时间复杂度: O(N^2)
     * @param num
     * @param words
     * @return
     */
    public List<String> getValidT9Words(String num, String[] words) {
        Map<Character, String> map = new HashMap<Character, String>(){{put('2', "abc"); put('3', "def"); put('4', "ghi");
        put('5', "jkl"); put('6', "mno"); put('7', "pqrs"); put('8', "tuv"); put('9', "wxyz");}};
        List<String> res = new ArrayList<>();

        for (String word : words) {
            char[] wordArray = word.toCharArray();
            if(wordArray.length != num.length()) {
                continue;
            }else{
                int i=0;
                boolean flag = true;
                while (i<num.length()){
                    char n = num.charAt(i);
                    char c = wordArray[i];
                    if(!map.get(n).contains(String.valueOf(c))){
                        flag = false;
                    }
                    i ++;
                }
                if(flag){
                    res.add(word);
                }
            }
        }
        return res;
    }


}

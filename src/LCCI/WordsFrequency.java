package LCCI;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/8/17 16:32
 * @desc: https://leetcode-cn.com/problems/words-frequency-lcci/
 */
public class WordsFrequency {

    Map<String, Integer> map = new HashMap<>();

    /**
     * hashMap方法
     */
    public WordsFrequency(String[] book) {
        for(int i=0; i<book.length; i++) {
            if(!map.keySet().contains(book[i])) {
                map.put(book[i], 1);
            }else{
                map.put(book[i], map.get(book[i])+1 );
            }
        }
    }

    public int get(String word) {
        if(map.keySet().contains(word)){
            return map.get(word);
        }

        return 0;
    }
}

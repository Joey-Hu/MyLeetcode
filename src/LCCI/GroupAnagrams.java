package LCCI;

import java.util.*;

/**
 * @author: huhao
 * @time: 2020/8/21 22:27
 * @desc: https://leetcode-cn.com/problems/group-anagrams-lcci/
 */
public class GroupAnagrams {
    /**
     * 每一个字符串匹配一个长度为26的数组，字母出现一次加一，统计26个字母各自出现的次数
     * 将数组转化为key
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> res = new HashMap<>();

        for (String str : strs) {
            int[] charArray = new int[26];

            for(int i=0; i<str.length(); i++){
                charArray[str.charAt(i)-'a']++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i : charArray) {
                stringBuilder.append(i);
            }
//            if (!res.keySet().contains(stringBuilder.toString())){
//                res.put(stringBuilder.toString(), new ArrayList<>());
//            }else {
//                res.put(stringBuilder.toString(), res.get(stringBuilder.toString()));
//
//            }
            res.computeIfAbsent(stringBuilder.toString(), unused -> new LinkedList<>()).add(str);
        }
        return new ArrayList<>(res.values());

    }
}

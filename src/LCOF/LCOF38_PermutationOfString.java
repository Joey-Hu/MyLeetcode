package LCOF;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/10/29 19:45
 * @desc: https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 */
public class LCOF38_PermutationOfString {

    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        List<Character> tempList = new ArrayList<>();
        boolean[] isVisited = new boolean[charArray.length];
        pailie(charArray, isVisited, res, tempList);

        String[] res1 = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            res1[i] = res.get(i);
        }
        return res1;
    }

    private void pailie(char[] charArray, boolean[] isVisited, List<String> res, List<Character> tempList) {
        if (tempList.size() == charArray.length) {
            res.add(listToString(tempList));
        } else {
            for (int i = 0; i < charArray.length; i++) {
                if (!isVisited[i]) {
                    // 跳过重复值
                    if (i != 0 && charArray[i] == charArray[i-1] && !isVisited[i-1]) {
                        continue;
                    }
                    isVisited[i] = true;
                    tempList.add(charArray[i]);
                    pailie(charArray, isVisited, res, tempList);
                    tempList.remove(tempList.size()-1);
                    isVisited[i] = false;
                }
            }
        }
    }

    private String listToString(List<Character> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}

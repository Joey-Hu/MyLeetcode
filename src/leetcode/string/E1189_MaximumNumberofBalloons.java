package leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/9/30 15:01
 * @desc: https://leetcode.com/problems/maximum-number-of-balloons/
 */
public class E1189_MaximumNumberofBalloons {

    public int maxNumberOfBalloons(String text) {

        int[] chars = new int[26];
        for (char c : text.toCharArray()) {
            chars[c - 'a']++;
        }

        int min = chars[1];
        min = Math.min(min, chars[0]);
        min = Math.min(min, chars[11]/2);
        min = Math.min(min, chars[14]/2);
        min = Math.min(min, chars[13]);

        return min;
    }
}

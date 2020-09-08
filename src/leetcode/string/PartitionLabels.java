package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/4 10:48
 * @desc: https://leetcode.com/problems/partition-labels/
 */
public class PartitionLabels {

    /**
     * 贪心方法
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {

        int[] last = new int[26];
        // 记录每个字符最后出现的index
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }

        int j = 0;
        // 锚点，记录子字符串的起始位置
        int anchor = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            // 寻找目前为止出现过的最靠后的字符的index
            j = Math.max(j, last[S.charAt(i) - 'a']);
            // 表示到达最靠后的字符位置  smart!
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij");
    }
}

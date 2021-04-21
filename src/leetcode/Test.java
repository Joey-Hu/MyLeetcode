package leetcode;

import javax.crypto.Cipher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/12/17 20:08
 * @desc:
 */
public class Test {

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        backtrack(s, ans, 0, new ArrayList<>());
        return ans;
    }
    // pos-当前遍历到 s 字符串中的位置，tmp-当前存放已经确定好的 ip 段的数量
    private void backtrack(String s, List<String> ans, int pos, List<String> tmp) {
        if (tmp.size() == 4) {
            // 如果此时 pos 也刚好遍历完整个 s
            if (pos == s.length()) {
                // join 用法：例如 [[255],[255],[111],[35]] -> 255.255.111.35
                ans.add(String.join(".", tmp));
            }
            // 否则直接返回
            return;
        }

        // ip 地址每段最多有三个数字
        for (int i = 1; i <= 3; i++) {
            // 如果当前位置距离 s 末尾小于 3 就不用再分段了，直接跳出循环即可。
            if (pos + i > s.length()) {
                break;
            }

            // 将 s 的子串开始分段
            String segment = s.substring(pos, pos + i);
            int val = Integer.valueOf(segment);
            // 剪枝条件：段的起始位置不能为 0，段拆箱成 int 类型的长度不能大于 255
            if (segment.startsWith("0") && segment.length() > 1 || (i == 3 && val > 255)) {
                continue;
            }

            // 符合要求就加入到 tmp 中
            tmp.add(segment);
            // 继续递归遍历下一个位置
            backtrack(s, ans, pos + i, tmp);
            // 回退到上一个元素，即回溯
            tmp.remove(tmp.size() - 1);
        }
    }



    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {}

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        // 创建链表
//        ListNode raw = new ListNode(1);
//        ListNode cur = raw;
//        int[] val = new int[]{8, 3, 6, 5, 4, 7, 2};
//        for (int num : val) {
//            cur.next = new ListNode(num);
//            cur = cur.next;
//        }
//        cur.next = null;

        Test test = new Test();
        System.out.println(test.restoreIpAddresses("25525511135"));


    }
}

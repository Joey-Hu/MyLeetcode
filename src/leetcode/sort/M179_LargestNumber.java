package leetcode.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: huhao
 * @time: 2020/10/21 14:58
 * @desc: https://leetcode.com/problems/largest-number/
 */
public class M179_LargestNumber {
    /**
     * 自定义排序规则
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        // 数字数组转为字符串数组
        String[] stringArray = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            stringArray[i] = String.valueOf(nums[i]);
        }

        // 自定义排序规则
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1);
            }
        };

        // 排序
        Arrays.sort(stringArray, comparator);

        // corner case
        if (stringArray[0].charAt(0) == '0') {
            return "0";
        }

        // 合并输出
        StringBuilder sb = new StringBuilder();
        for(String s: stringArray) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,30,34,5,9};
        new M179_LargestNumber().largestNumber(nums);
    }
}

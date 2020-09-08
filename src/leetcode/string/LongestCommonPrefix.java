package leetcode.string;

/**
 * @author: huhao
 * @time: 2020/9/4 10:21
 * @desc: https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

    /**
     * 逐个比较
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = commonPrefix(prefix, strs[i]);
        }
        return prefix;
    }

    private String commonPrefix(String str1, String str2) {
        if (str1 == "" || str2 == "") {
            return "";
        }
        int minLength = Math.min(str1.length(), str2.length());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                stringBuilder.append(str1.charAt(i));
            }else {
                break;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"aca","cba"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }


}

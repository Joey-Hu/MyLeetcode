package favoritelist;

/**
 * @author: huhao
 * @time: 2020/8/19 21:39
 * @desc:
 */
public class LongestCommonPrefix0819 {
    /**
     * 横向扫描
     * 思路：逐个对strs中的两个str求最长前缀
     * LCP(str1, str2, str3, ... ...) = LCP(LCP(LCP(LCP(str1, str2), str3), str4), ... ...)
     * 举例：
     * strs[] = {"flower","flow","flight"}
     * lcp1 = LCP(str1, str2) = "flow"
     * lcp2 = LCP(lcp1, str3) = "fl"
     * 时间复杂度：O(mn)，其中 m 是字符串数组中的字符串的平均长度，n 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for(int i=1; i<strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<len; i++) {
            if(str1.charAt(i) == str2.charAt(i)) {
                sb.append(str1.charAt(i));
            }else{
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"aca","cba"};
        LongestCommonPrefix0819 longestCommonPrefix0819 = new LongestCommonPrefix0819();
        longestCommonPrefix0819.longestCommonPrefix(strs);
    }
}

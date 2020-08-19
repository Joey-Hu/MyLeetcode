package favoritelist;

/**
 * @author: huhao
 * @time: 2020/8/19 21:39
 * @desc:
 */
public class LongestCommonPrefix0819I {
    /**
     * 横向扫描 + 分治思想
     * 思路：逐次对strs中的一半str求最长前缀
     * LCP(str1, str2, str3, ... ...) = LCP(LCP(str1 ... strk), LCP(str_k+1 ... str_n))
     *
     * 时间复杂度：O(mn)，其中 m 是字符串数组中的字符串的平均长度，n 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }else{
            return longestCommonPrefix(strs, 0, strs.length-1);
        }
    }

    private String longestCommonPrefix(String[] strs, int start, int end) {

        if(start == end){
            return strs[start];
        }else {
            int mid = start + (end - start) / 2;
//            String leftLCP = longestCommonPrefix(strs, start, mid-1);
//            String rightLCP = longestCommonPrefix(strs, mid, end);
            String leftLCP = longestCommonPrefix(strs, start, mid);
            String rightLCP = longestCommonPrefix(strs, mid+1, end);
            return CommonPrefix(leftLCP, rightLCP);
        }
    }

    public String CommonPrefix(String str1, String str2) {
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
        LongestCommonPrefix0819I longestCommonPrefix0819 = new LongestCommonPrefix0819I();
        longestCommonPrefix0819.longestCommonPrefix(strs);
    }
}

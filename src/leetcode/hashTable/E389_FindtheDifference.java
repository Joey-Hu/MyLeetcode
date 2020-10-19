package leetcode.hashTable;

/**
 * @author: huhao
 * @time: 2020/10/19 19:36
 * @desc: https://leetcode.com/problems/find-the-difference/
 */
public class E389_FindtheDifference {

    /**
     * 字符转成整数相加 巧妙
     * ref：https://leetcode.com/problems/find-the-difference/discuss/86850/Simple-JAVA-8ms-solution-4-lines
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference2(String s, String t) {
        int sCharSum = 0;
        int tCharSum = 0;

        for (int i = 0; i < s.length(); i++) {
            sCharSum += (int)s.charAt(i);
        }

        for (int i = 0; i < t.length(); i++) {
            tCharSum += (int)t.charAt(i);
        }

        return (char)(tCharSum - sCharSum);
    }

    /**
     * 两个长度为26的数组
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        int[] array = new int[26];
        int idx = 0;


        for (int i = 0; i < t.length(); i++) {
            array[t.charAt(i)-'a'] ++;
        }

        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i)-'a'] --;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) {
                idx = i;
                break;
            }
        }
        return (char)(idx + 'a');
    }
}

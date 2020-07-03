package LCCI;

import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/6/29 10:24
 * @desc: https://leetcode-cn.com/problems/check-permutation-lcci/
 */
public class CheckPermutation {

    public boolean CheckPermutation(String s1, String s2) {

        // 转换成数组，排序 O(nlogn)
        // https://www.jianshu.com/p/e2b7256163ae
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();

        if(charArray1.length != charArray2.length){
            return false;
        }

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        for(int i=0; i<charArray1.length; i++){
            if(charArray1[i]!=charArray2[i]){
                return false;
            }
        }
        return true;
    }

    public boolean CheckPermutation2(String s1, String s2) {

        if(s1.length() != s2.length()){
            return false;
        }

        int[] ascii = new int[123];

        for(int i=0; i<s1.length(); i++){
            int index1 = (int)s1.charAt(i);
            int index2 = (int)s2.charAt(i);

            ascii[index1]++;
            ascii[index2]--;
        }
        for(int i=0; i<ascii.length; i++){
            if(ascii[i]!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bad";

        CheckPermutation checkPermutation = new CheckPermutation();
        System.out.println(checkPermutation.CheckPermutation2(s1, s2));
    }
}

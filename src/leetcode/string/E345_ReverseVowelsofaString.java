package leetcode.string;

/**
 * @author: huhao
 * @time: 2020/11/9 20:05
 * @desc: https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
public class E345_ReverseVowelsofaString {

    public String reverseVowels(String s) {
        if (s == null || s.length()==0) {
            return s;
        }

        String vowels = "aeiouAEIOU";
        char[] sCharArray = s.toCharArray();
        int left = 0;
        int right = sCharArray.length-1;
        while (left < right) {
            while (left < right && !vowels.contains(sCharArray[left]+"")) {
                left ++;
            }
            while (left < right && !vowels.contains(sCharArray[right]+"")) {
                right --;
            }
            char temp = sCharArray[left];
            sCharArray[left] = sCharArray[right];
            sCharArray[right] = temp;

            left ++;
            right --;
        }
        return new String(sCharArray);
    }
}

package LCCI;

/**
 * @author: huhao
 * @time: 2020/6/29 11:26
 * @desc:
 */
public class PalindromePermutation {

    public boolean canPermutePalindrome(String s) {

        int[] ascii = new int[122];
        int length = s.length();

        for(int i=0; i<length; i++){
            int index = (int)s.charAt(i);
            if(ascii[index]==1){
                ascii[index] = 0;
            }else if(ascii[index]==0){
                ascii[index] = 1;
            }
        }

        int count = 0;
        for(int i=0; i<ascii.length;i++){
            if(ascii[i] == 1){
                count++;
            }
        }

        if(length%2==1 && count==1){
            return true;
        }else if(length%2==0 && count==0){
            return true;
        }

        return false;

    }
}

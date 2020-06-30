package LCCI;

import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/6/29 11:42
 * @desc:
 */
public class OneAway {

    public boolean oneEditAway(String first, String second) {

        if(first == null || second == null){
            return false;
        }

        int length1 = first.length();
        int length2 = second.length();

        int i = 0;
        int j = length1-1;
        int k = length2-1;

        while(i<length1 && i<length2 && first.charAt(i)==second.charAt(i)){
            ++i;
        }

        while (j>=0 && k>=0 && first.charAt(j) == second.charAt(k)){
            --j;
            --k;
        }
        return j-i<1 && k-i<1;
    }

    public static void main(String[] args) {
        OneAway oneAway = new OneAway();
        oneAway.oneEditAway("teacher", "treacher");

    }
}

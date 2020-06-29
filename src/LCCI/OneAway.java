package LCCI;

/**
 * @author: huhao
 * @time: 2020/6/29 11:42
 * @desc:
 */
public class OneAway {

    public boolean oneEditAway(String first, String second) {

        int length1 = first.length();
        int length2 = second.length();

        if(Math.abs(length1-length2)>1){
            return false;
        }

    }
}

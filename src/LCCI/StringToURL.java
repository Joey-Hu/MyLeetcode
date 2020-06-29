package LCCI;

import java.util.ArrayList;

/**
 * @author: huhao
 * @time: 2020/6/29 10:57
 * @desc:
 */
public class StringToURL {

    public String replaceSpaces(String S, int length) {

        int sLength = S.length();
        ArrayList<String> ret = new ArrayList<String>();

        for(int i=0; i<length; i++){
            if((int)S.charAt(i)==Integer.valueOf(' ')){
                ret.add("%20");
            }else{
                ret.add(Character.toString(S.charAt(i)));
            }
        }

        String s = String.join("", ret);
        return s;
    }

    public String replaceSpaces2(String S, int length) {

        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0; i<length; i++){
            if(S.charAt(i) == ' '){
                stringBuilder.append("%20");
            }else{
                stringBuilder.append(S.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}

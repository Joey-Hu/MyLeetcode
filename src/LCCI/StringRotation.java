package LCCI;

public class StringRotation {

    public boolean isFlipedString(String s1, String s2) {
        // 旋转字符串存在两倍原字符串当中，查找子串
        if(s1.length() != s2.length()){
            return false;
        }

        if(s1.equals(s2)){
            return true;
        }

        String s3 = s2+s2;
        return s3.contains(s1);
    }
}

package LCCI;

public class CompressString {

    public String compressString(String S) {
        // https://leetcode-cn.com/problems/compress-string-lcci/
        // 朴素算法
        if(S.length()<2){
            return S;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        char c = S.charAt(0);
        for(int i=1; i<S.length(); i++){
            if(S.charAt(i) != c){
                stringBuilder.append(c);
                stringBuilder.append(count);
                c = S.charAt(i);
                count = 1;
            }else{
                count++;
            }

            if(i == S.length()-1){
                stringBuilder.append(c);
                stringBuilder.append(count);
            }
        }

        String S2 = stringBuilder.toString();

        if(S.length()>S2.length()){
            return S2;
        }else{
            return S;
        }
    }
}

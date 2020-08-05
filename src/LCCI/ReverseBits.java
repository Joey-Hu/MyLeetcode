package LCCI;

/**
 * @author: huhao
 * @time: 2020/8/5 10:27
 * @desc:
 */
public class ReverseBits {
    public int reverseBits(int num) {

        int curLen = 0;
        int preLen = 0;
        int maxLen = 0;
        for(int i=0; i<32; i++){
            if((num >>> i & 1) == 1){
                curLen ++;
            }
            else{
                maxLen = Math.max(maxLen, curLen+preLen+1);
                preLen = curLen;
                curLen = 0;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        reverseBits.reverseBits(2147483647);

    }

}

package leetcode.string;

/**
 * @author: huhao
 * @time: 2020/9/28 16:19
 * @desc: https://leetcode.com/problems/robot-return-to-origin/
 */
public class E890_FindandReplacePattern {
    /**
     * 如果L和R数量相等，U和D数量相等，则返回原点
     * @param moves
     * @return
     */
    public boolean judgeCircle(String moves) {
        int L = 0;
        int U = 0;

        for (int i = 0; i <moves.length() ; i++) {
            char c = moves.charAt(i);
            if (c == 'L') {
                L ++;
            }else if (c == 'R') {
                L --;
            }else if (c == 'U') {
                U ++;
            } else {
                U --;
            }
        }
        return L == 0 && U == 0;
    }

}

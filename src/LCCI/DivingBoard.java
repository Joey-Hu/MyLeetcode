package LCCI;

/**
 * @author: huhao
 * @time: 2020/8/31 14:01
 * @desc: https://leetcode-cn.com/problems/diving-board-lcci/
 */
public class DivingBoard {

    /**
     * 简单数学题
     * @param shorter
     * @param longer
     * @param k
     * @return
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[]{};
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }

        int[] res = new int[k+1];
        for (int i = 0; i < k + 1; i++) {
            res[i] = (k - i) * shorter + i * longer;
        }
        return res;
    }

}

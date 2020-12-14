package leetcode.twopointsAndslidewindow;

/**
 * @author: huhao
 * @time: 2020/12/13 13:09
 * @desc: https://leetcode.com/problems/sum-of-square-numbers/
 */
public class E633_SumofSquareNumbers {

    /**
     * 双指针
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {

        int low = 0;
        int high = (int) Math.sqrt(c);

        while (low <= high) {
            int sum = low * low + high * high;
            if (sum > c) {
                high --;
            }else if (sum < c) {
                low ++;
            }else {
                return true;
            }
        }
        return false;
    }
}

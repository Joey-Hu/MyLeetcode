package leetcode.binarysearch_divideAndConquer;

/**
 * @author: huhao
 * @time: 2020/12/14 20:37
 * @desc: https://leetcode.com/problems/sqrtx/
 */
public class E69_Sqrtx {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int low = 1;
        int high = x;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            }else if (sqrt > mid) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return high;
    }
}

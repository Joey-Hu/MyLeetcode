package nowcoder.neteasy;

import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/9/25 20:33
 * @desc: https://www.nowcoder.com/questionTerminal/14c0359fb77a48319f0122ec175c9ada
 */
public class grapes {

    /**
     * 将该问题看成是平分以a, b, c为边组成的多边形
     * @param a
     * @param b
     * @param c
     * @return
     */
    public long solution (long a, long b, long c) {
        long[] nums = new long[]{a, b, c};
        long sum = a + b + c;

        Arrays.sort(nums);

        // 能够组成三角形
        if (nums[0] + nums[1] > nums[2]) {
            return (sum + 2) / 3;
        }

        // 差距很大时
        if (2*(nums[0] + nums[1]) < nums[2]) {
            return (nums[2]+1) / 2;
        }

        // 不能够组成三角形，但差距不大
        return (sum + 2) / 3;
    }
}

package LCOF;

/**
 * @author: huhao
 * @time: 2020/11/3 9:55
 * @desc: https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 */
public class LCOF66_BuildProductArray {
    /**
     * 构建左右乘积数组
     * 左乘积数组left[i]表示A[0]到A[i-1]的累计乘积
     * 右乘积数组right[i]表示A[n-1]到A[i+1]的累计乘积
     * 所以结果数组B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1] = left[i] * right[i]
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        int[]  res = new int[a.length];
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            left[i] = 1;
            right[i] = 1;
        }

        for (int i = 1; i < left.length; i ++) {
            left[i] = a[i-1] * left[i-1];
        }

        for (int i = right.length-2; i >= 0; i --) {
            right[i] = a[i+1] * right[i+1];
        }

        for (int i = 0; i < a.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}

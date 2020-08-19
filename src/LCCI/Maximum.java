package LCCI;

/**
 * @author: huhao
 * @time: 2020/8/19 10:14
 * @desc: https://leetcode-cn.com/problems/maximum-lcci/
 * 利用公式 max(a, b) = (|a - b|+a+b) / 2
 * 为防止a+b溢出，将a和b转为long类型
 */
public class Maximum {
    public int maximum(int a, int b) {
        long c = a;
        long d = b;

        return (int)(Math.abs(c-d)+c+d) / 2;
    }
}

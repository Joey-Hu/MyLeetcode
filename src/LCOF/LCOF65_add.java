package LCOF;

/**
 * @author: huhao
 * @time: 2020/11/2 10:29
 * @desc: https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 */
public class LCOF65_add {

    /**
     * 相加各位的值，不算进位，二进制每位相加就相当于各位做异或操作，即 a ^ b ；
     * 计算进位值，相当于各位做与操作，再向左移一位,，即 (a & b) << 1。
     * 重复上述两步， 各位相加 ，计算进位值。进位值为0，跳出循环
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        while (b != 0) {
            int tmp = (a & b) << 1;
            a = a ^ b;
            b = tmp;
        }
        return a;
    }
}

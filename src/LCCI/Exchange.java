package LCCI;

/**
 * @author: huhao
 * @time: 2020/8/19 11:23
 * @desc: https://leetcode-cn.com/problems/exchange-lcci/
 */
public class Exchange {
    /**
     * 取出给定数字的奇数位和偶数位，将奇数位的数字左移1位，偶数位的数字右移1位，再将两部分或起来就是结果了。
     * @param num
     * @return
     */
    public int exchangeBits(int num) {
        // 0x55555555 = 0b0101_0101_0101_0101_0101_0101_0101_0101
        // 0xaaaaaaaa = 0b1010_1010_1010_1010_1010_1010_1010_1010
        int even = num & 0xaaaaaaaa;
        int odd = num & 0x55555555;
        odd <<= 1;
        even >>= 1;
        return odd | even;

    }
}

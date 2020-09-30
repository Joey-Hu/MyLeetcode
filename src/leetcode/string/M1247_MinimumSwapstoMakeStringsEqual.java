package leetcode.string;

/**
 * @author: huhao
 * @time: 2020/9/30 14:04
 * @desc: https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/
 */
public class M1247_MinimumSwapstoMakeStringsEqual {

    public int minimumSwap(String s1, String s2) {
        // s1中x的数量(跳过前面相同的字符)
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;

        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if (ch1 == ch2) {
                continue;
            }

            if (ch1 == 'x') {
                x1 ++;
            }else {
                y1 ++;
            }

            if (ch2 == 'x') {
                x2 ++;
            } else {
                y2 ++;
            }
        }

        // 如果x的数量或者y的数量为奇数，则不可能使s1等于s2
        if ((x1 + x2) % 2 != 0 || (y1 + y2) % 2 != 0) {
            return -1;
        }

        int swaps = x1 / 2 + y1 / 2 + (x1 % 2) * 2;
        // Cases to do 1 swap:
        // "xx" => x1 / 2 => how many pairs of 'x' we have ?
        // "yy" => y1 / 2 => how many pairs of 'y' we have ?
        //
        // Cases to do 2 swaps:
        // "xy" or "yx" =>  x1 % 2

        return swaps;

    }
}

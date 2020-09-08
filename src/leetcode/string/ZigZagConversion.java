package leetcode.string;

/**
 * @author: huhao
 * @time: 2020/9/4 9:38
 * @desc:  https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {

        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuffer();
        }

        int i = 0;
        while (i < len) {
            // 竖直向下
            for (int idx = 0; i < len && idx < numRows; idx++) {
                sb[idx].append(c[i++]);
            }
            // 斜向上
            for (int idx = numRows-2; i < len && idx >= 1; idx--) {
                sb[idx].append(c[i++]);
            }
        }
        for (int j = 1; j < sb.length; j++) {
            sb[0].append(sb[j]);

        }
        return sb[0].toString();
    }

    public static void main(String[] args) {
        new ZigZagConversion().convert("PAYPALISHIRING", 3);
    }
}

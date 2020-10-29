package LCOF;

/**
 * @author: huhao
 * @time: 2020/10/29 10:25
 * @desc: https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 */
public class LCOF29_SpiralMatrix {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length-1;
        int idx = 0;
        int[] res = new int[matrix.length * matrix[0].length];

        char[] dirs = new char[]{'R', 'D', 'L', 'U'};
        int changeDir = 0;

        while(left <= right && top <= bottom) {

            char dir = dirs[changeDir % 4];
            if (dir == 'R') {
                for (int j = left; j <= right; j++) {
                    res[idx++] = matrix[top][j];
                }
                // 注意改变的条件
                top ++;
            }

            if (dir == 'D') {
                for (int i = top; i <= bottom; i++) {
                    res[idx++] = matrix[i][right];
                }
                right --;
            }

            if (dir == 'L') {
                for (int j = right; j >= left; j--) {
                    res[idx++] = matrix[bottom][j];
                }
                bottom--;
            }

            if (dir == 'U') {
                for (int i = bottom; i >= top; i--) {
                    res[idx++] = matrix[i][left];
                }
                left ++;
            }
            changeDir ++;
        }
        return res;
    }
}

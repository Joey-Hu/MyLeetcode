package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/4 16:00
 * @desc: https://leetcode.com/problems/set-matrix-zeroes/
 */
public class M73_SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        List<Integer> zeroRow = new ArrayList<>();
        List<Integer> zeroCol = new ArrayList<>();

        // 记录0的横纵坐标
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroRow.add(i);
                    zeroCol.add(j);
                }
            }
        }

        // 置零
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (zeroRow.contains(i) || zeroCol.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

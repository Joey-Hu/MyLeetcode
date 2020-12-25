package leetcode.binarysearch_divideAndConquer;

/**
 * @author: huhao
 * @time: 2020/10/9 21:56
 * @desc: https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
public class M240_Searcha2DMatrixII {

    /**
     * 从右上角或左下角开始
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || (matrix[0].length == 0) ) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }else if (matrix[row][col] > target) {
                col --;
            }else {
                row ++;
            }
        }
        return false;
    }

}

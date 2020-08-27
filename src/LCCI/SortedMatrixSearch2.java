package LCCI;

/**
 * @author: huhao
 * @time: 2020/8/27 20:24
 * @desc: https://leetcode-cn.com/problems/sorted-matrix-search-lcci/
 */
public class SortedMatrixSearch2 {

    /**
     * 从数组的右上角开始搜索，当前元素比目标元素小，就向下搜寻，比目标元素大就向左搜寻。
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] > target) {
                // 向左
                col --;
            }else if (matrix[row][col] < target) {
                // 向下
                row ++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        new SortedMatrixSearch2().searchMatrix(matrix, 20);
    }
}

package LCCI;

/**
 * @author: huhao
 * @time: 2020/8/27 20:24
 * @desc: https://leetcode-cn.com/problems/sorted-matrix-search-lcci/
 */
public class SortedMatrixSearch {

    /**
     * 二分查找
     * 先逐行进行二分查找，截止到matrix[i][0]>target为止
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) {
                return false;
            }

            int left = 0;
            int right = matrix[i].length-1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (target < matrix[i][mid]) {
                    right = mid - 1;
                } else if (target > matrix[i][mid]) {
                    left = mid + 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        new SortedMatrixSearch().searchMatrix(matrix, 20);
    }
}

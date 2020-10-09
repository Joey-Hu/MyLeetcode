package leetcode.binarysearch_divideAndConquer;

/**
 * @author: huhao
 * @time: 2020/10/9 21:11
 * @desc: https://leetcode.com/problems/search-a-2d-matrix/
 */
public class M74_Searcha2DMatrix {

    /**
     * clever
     * 直接把它看作是sorted list
     * https://leetcode.com/problems/search-a-2d-matrix/discuss/26220/Don't-treat-it-as-a-2D-matrix-just-treat-it-as-a-sorted-list
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0;
        int high = row * col - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid/col][mid%col] == target) {
                return true;
            }else if (matrix[mid/col][mid%col] < target) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return false;
    }

    /**
     * 先找行，再找元素index
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        // 先找行
        if (matrix.length == 0 || (matrix[0].length == 0) ) {
            return false;
        }
        int row = 0;
        int low = 0;
        int high = matrix.length-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid][0] <= target) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        if (high < 0) {
            return false;
        }else {
            row = high;
        }

        low = 0;
        high = matrix[0].length - 1;
        // 寻找target
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[row][mid] == target) {
                return true;
            }else if (matrix[row][mid] < target) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1}};
        new M74_Searcha2DMatrix().searchMatrix(matrix, 0);
    }
}

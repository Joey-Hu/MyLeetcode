package leetcode.heap;

import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/9/30 18:03
 * @desc: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class M378_KthSmallestElementinaSortedMatrix {

    /**
     * Array + sort
     * O(n^2)
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] array = new int[rows*cols];
        int idx = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0 ; j < cols; j++) {
                array[idx++] = matrix[i][j];
            }
        }

        Arrays.sort(array);
        return array[k-1];
    }

    /**
     * Binary search
     * O(N∗log(max−min))
     * An alternate could be to apply the Binary Search on the “number range” instead of the “index range”.
     * ref: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/301357/Java-0ms-(added-Python-and-C%2B%2B)%3A-Easy-to-understand-solutions-using-Heap-and-Binary-Search
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest2(int[][] matrix, int k) {
        int low = matrix[0][0];
        // [low, high)
        int high = matrix[matrix.length-1][matrix[0].length-1]+1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            int j = matrix[0].length - 1;
            for (int i = 0; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > mid){
                    j --;
                }
                count = count + j + 1;
            }
            if (count < k) {
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return low;
    }

    /**
     * heap: O(min(K,N)+K∗logN)
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest3(int[][] matrix, int k) {
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,5,9}, {10,11,13}, {12,13,15}};
        new M378_KthSmallestElementinaSortedMatrix().kthSmallest2(matrix, 8);
    }
}

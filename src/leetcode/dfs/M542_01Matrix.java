package leetcode.dfs;

/**
 * @author: huhao
 * @time: 2020/10/27 11:43
 * @desc: https://leetcode.com/problems/01-matrix/
 */
public class M542_01Matrix {

    public int[][] updateMatrix(int[][] matrix) {
        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                searchDFS(matrix, 0, i, j)
            }

        }
    }

    private int searchDFS(int[][] matrix, int minDistance, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == 0) {
            return minDistance;
        }
        minDistance ++;
        minDistance = Math.min(Math.min(searchDFS(matrix, minDistance, i-1, j), searchDFS(matrix, minDistance, i+1, j)), Math.min())
    }

}

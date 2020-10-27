package leetcode.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: huhao
 * @time: 2020/10/27 11:43
 * @desc: https://leetcode.com/problems/01-matrix/
 */
public class M542_01Matrix {

    /**
     * BFS 多源最短路径
     * ref: https://www.youtube.com/watch?v=YTnYte6U61w
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
                else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n || matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) {
                    continue;
                }
                queue.add(new int[] {r, c});
                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
            }
        }

        return matrix;
    }

    /**
     * 动态规划
     * @param matrix
     * @return
     */
    public int[][] updateMatrix2(int[][] matrix) {
        return null;
    }


        public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,0,0},{0,1,0},{1, 1, 1}};
        new M542_01Matrix().updateMatrix(matrix);
    }

}

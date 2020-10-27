package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/10/27 9:20
 * @desc: https://leetcode.com/problems/pacific-atlantic-water-flow/
 */
public class M417_PacificAtlanticWaterFlow {

    /**
     * dfs
     * 把所有边缘点当作起点开始遍历搜索，然后标记能到达的点为 true，
     * 分别标记出 pacific 和 atlantic 能到达的点，那么最终能返回的点就是二者均为 true 的点。
     * @param matrix
     * @return
     */
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // check the first and last columns
        for (int i = 0; i < rows; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, cols-1);
        }

        // check the top and bottom rows
        for (int j = 0; j < cols; j++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, j);
            dfs(matrix, atlantic, Integer.MIN_VALUE, rows-1, j);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(new ArrayList<>(temp));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int height, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j] || matrix[i][j] < height) {
            return;
        }
        visited[i][j] = true;

        dfs(matrix, visited, matrix[i][j], i-1, j);
        dfs(matrix, visited, matrix[i][j], i+1, j);
        dfs(matrix, visited, matrix[i][j], i, j-1);
        dfs(matrix, visited, matrix[i][j], i, j+1);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        new M417_PacificAtlanticWaterFlow().pacificAtlantic(matrix);
    }
}

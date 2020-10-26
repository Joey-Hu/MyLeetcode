package leetcode.dfs;

/**
 * @author: huhao
 * @time: 2020/10/26 16:39
 * @desc: https://leetcode.com/problems/max-area-of-island/
 */
public class M695_MaxAreaofIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, boundaryDFS(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int boundaryDFS(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = -1;
            return 1 + boundaryDFS(grid, i-1, j) + boundaryDFS(grid, i+1, j) + boundaryDFS(grid, i, j-1) + boundaryDFS(grid, i, j+1);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        new M695_MaxAreaofIsland().maxAreaOfIsland(grid);
    }
}

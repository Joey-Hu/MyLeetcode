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
                    int area = 0;
                    boundaryDFS(grid, i, j, area);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private void boundaryDFS(int[][] grid, int i, int j, int area) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == 1) {
            grid[i][j] = -1;
            area ++;
        }

        if (i > 0 && grid[i-1][j] == 1) {
            boundaryDFS(grid, i-1, j, area);
        }

        if (i < grid.length-1 && grid[i+1][j] == 1) {
            boundaryDFS(grid, i+1, j, area);
        }

        if (j > 0 && grid[i][j-1] == 1) {
            boundaryDFS(grid, i, j-1, area);
        }

        if (j < grid[0].length-1 && grid[i][j+1] == 1) {
            boundaryDFS(grid, i, j+1, area);
        }
        return;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        new M695_MaxAreaofIsland().maxAreaOfIsland(grid);
    }
}

package leetcode.dfs;

/**
 * @author: huhao
 * @time: 2020/10/19 21:39
 * @desc: https://leetcode.com/problems/island-perimeter/
 */
public class E463_IslandPerimeter {

    /**
     * 计算是边界或者是与水域相邻的边数
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) {
                        res++; // UP
                    }
                    if (j == 0 || grid[i][j - 1] == 0) {
                        res++; // LEFT
                    }
                    if (i == grid.length -1 || grid[i + 1][j] == 0) {
                        res++; // DOWN
                    }
                    if (j == grid[0].length -1 || grid[i][j + 1] == 0) {
                        res++; // RIGHT
                    }
                }
            }
        }
        return res;
    }

    private int surroundIslands(int[][]grid, int i, int j) {
        int res = 0;

        // top
        if (j-1 >= 0 && grid[i][j-1] == 1) {
            res ++;
        }

        // bottom
        if (j+1 < grid.length && grid[i][j+1] == 1) {
            res ++;
        }

        // left
        if (i-1 >=0 && grid[i-1][j] == 1) {
            res ++;
        }

        // right
        if (i+1 < grid[0].length && grid[i+1][j] == 1) {
            res ++;
        }

        return 4 - res;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0}};
        System.out.println(new E463_IslandPerimeter().islandPerimeter(grid));
    }
}

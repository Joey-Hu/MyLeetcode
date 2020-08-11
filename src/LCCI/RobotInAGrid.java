package LCCI;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/8/10 22:21
 * @desc: https://leetcode-cn.com/problems/robot-in-a-grid-lcci/
 */
public class RobotInAGrid {
    private int row;
    private int col;
    private int[][] visited;
    private int[][] move = new int[][]{{1, 0}, {0, 1}};

    /**
     * dfs + 路径记录
     * @param obstacleGrid
     * @return
     */

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        row = obstacleGrid.length;
        col = obstacleGrid[0].length;

        visited = new int[row][col];
        List<List<Integer>> res = new ArrayList<>();
        if(dfs(res, obstacleGrid, 0, 0)){
            return res;
        }
        res.clear();
        return res;
    }

    private boolean dfs(List<List<Integer>> res, int[][] obstacleGrid, int x, int y) {
        // 终止条件1：超出边界 or 无路可走
        if(x >= row || y >= col || visited[x][y] == 1 || obstacleGrid[x][y] == 1){
            return false;
        }

        List<Integer> grid = new ArrayList<>();
        grid.add(x);
        grid.add(y);
        res.add(grid);
        // 终止条件2：到达终点
        if(x == row-1 && y == col-1) {
            return true;
        }
        visited[x][y] = 1;
        // 尝试向下走或向右走
        for(int i=0; i<2; i++){
            int nx = x + move[i][0];
            int ny = y + move[i][1];
            if(dfs(res, obstacleGrid, nx, ny)){
                return true;
            }
        }
        res.remove(res.size()-1);
        return false;
    }

    public static void main(String[] args) {
        RobotInAGrid robotInAGrid = new RobotInAGrid();
        int[][] obstacleGrid = new int[][]{{0, 1, 0}, {1, 1, 0}, {0, 0, 0}};
        System.out.println(robotInAGrid.pathWithObstacles(obstacleGrid));
    }
}

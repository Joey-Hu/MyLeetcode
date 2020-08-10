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



}

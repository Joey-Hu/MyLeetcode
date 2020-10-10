package leetcode.binarysearch_divideAndConquer;

/**
 * @author: huhao
 * @time: 2020/10/10 11:12
 * @desc: https://leetcode.com/problems/dungeon-game/
 */
public class H174_DungeonGame {

    /**
     * 动态规划
     * 和64. Minimum Path Sum题类似
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row+1][col+1];

        // 初始化最后一行
        for (int i = 0; i < col+1; i ++) {
            dp[row][i] = Integer.MAX_VALUE;
        }
        // 初始化最后一列
        for (int i = 0; i < row+1; i ++) {
            dp[i][col] = Integer.MAX_VALUE;
        }

        dp[row-1][col] = 1;
        dp[row][col-1] = 1;

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                // 表示过该单元格所需的hp
                int need = Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j];
                // 如果need小于等于0，表示以目前通过
                dp[i][j] = need <= 0 ? 1 : need;
            }
        }
        return dp[0][0];
    }
}

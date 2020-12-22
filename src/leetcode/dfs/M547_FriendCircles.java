package leetcode.dfs;

/**
 * @author: huhao
 * @time: 2020/12/22 22:13
 * @desc: https://leetcode.com/problems/friend-circles/
 */
public class M547_FriendCircles {

    /**
     * 向下、向右深度遍历
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        int numCircle = 0;
        int[][] isVisited = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    numCircle ++;
                    dfs(M, i, j, isVisited);
                }
            }
        }
        return numCircle;
    }

    private void dfs(int[][] M, int i, int j, int[][] isVisited) {
        if (i >= 0 && i < M.length && j >= 0 && j < M[0].length && M[i][j] == 1 && isVisited[i][i] == 0) {
            M[i][j] = -1;
            isVisited[i][j] = 1;
            isVisited[j][i]
            dfs(M, i+1, j);
            dfs(M, i, j+1);
        }
        return;
    }
}

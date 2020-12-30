package leetcode.bfs;

/**
 * @author: huhao
 * @time: 2020/12/25 15:07
 * @desc: https://leetcode.com/problems/shortest-bridge/
 */
public class M934_ShortestBridge {

    /**
     * 先找到第一个岛，把 1 置换成 2
     * @param A
     * @return
     */
    public int shortestBridge(int[][] A) {

        int res = 0;

        // dfs: 找到第一个岛
        for (int i = 0; i < A.length; i ++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j);
                }
            }
        }
        return 0;
    }

    private void dfs(int[][] A, int i, int j) {
        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length || A[i][j] == 0) {
            return;
        }

        A[i][j] = 2;
        dfs(A, i-1, j);
        dfs(A, i+1, j);
        dfs(A, i, j-1);
        dfs(A, i, j+1);
    }
}

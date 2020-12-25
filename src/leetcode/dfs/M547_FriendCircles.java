package leetcode.dfs;

/**
 * @author: huhao
 * @time: 2020/12/22 22:13
 * @desc: https://leetcode.com/problems/friend-circles/
 */
public class M547_FriendCircles {

    /**
     * 深度遍历
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        boolean[] isVisited = new boolean[M.length];
        int res = 0;
        for (int i = 0; i < M.length; i++) {
            if (!isVisited[i]) {
                // 如果 i 未被访问，则进行dfs
                dfs(M, isVisited, i);
                res ++;
            }
        }
        return res;
    }

    private void dfs(int[][] M, boolean[] isVisited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && isVisited[j] == false) {
                // 传递
                isVisited[j] = true;
                dfs(M, isVisited, j);
            }
        }
    }
}

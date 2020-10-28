package LCOF;

/**
 * @author: huhao
 * @time: 2020/10/28 19:12
 * @desc: https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class LCOF13_Therangeofmotionoftherobot {

    /**
     * DFS
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {

        int res = 0;
        boolean[][] isVisited = new boolean[m][n];
        return searchDFS(m, n, k, isVisited, 0, 0);
    }

    private int searchDFS(int m, int n, int k, boolean[][] isVisited, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || isVisited[row][col] || getDigitsSum(row) + getDigitsSum(col)
                > k) {
            return 0;
        }
        isVisited[row][col] = true;

        return 1 + searchDFS(m, n, k, isVisited, row-1, col) + searchDFS(m, n, k, isVisited, row+1, col) +
        searchDFS(m, n, k, isVisited, row, col-1) + searchDFS(m, n, k, isVisited, row, col+1);
    }

    private int getDigitsSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        new LCOF13_Therangeofmotionoftherobot().movingCount(2, 3, 1);
    }
}

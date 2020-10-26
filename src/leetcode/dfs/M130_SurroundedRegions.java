package leetcode.dfs;

/**
 * @author: huhao
 * @time: 2020/10/26 11:36
 * @desc: https://leetcode.com/problems/surrounded-regions/
 */
public class M130_SurroundedRegions {

    /**
     * 图的优先遍历
     * 扫矩阵的四条边，如果有O，则用 DFS 遍历，将所有连着的O都变成另一个字符，比如$，
     * 这样剩下的O都是被包围的，然后将这些O变成X，把$变回O就行了。
     * @param board
     */
    public void solve(char[][] board) {
        if (board.length == 0 ||  board[0].length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        // check the first and last column
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                boundaryDFS(board, i, 0);
            }
            if (board[i][cols-1] == 'O') {
                boundaryDFS(board, i, cols-1);
            }
        }

        // check the top and bottom row
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                boundaryDFS(board, 0, j);
            }
            if (board[rows-1][j] == 'O') {
                boundaryDFS(board, rows-1, j);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }else if (board[i][j] == '*'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void boundaryDFS(char[][] board, int i, int j) {
        if (i > board.length || i < 0 || j > board[0].length || j < 0) {
            return;
        }

        // 'O' on the border
        if (board[i][j] == 'O') {
            board[i][j] = '*';
        }

        // check the left cell, if left cell is 'O', turn it into '*'
        if (i > 0 && board[i-1][j] == 'O') {
            boundaryDFS(board, i-1, j);
        }

        if (i < board.length-1 && board[i+1][j] == 'O') {
            boundaryDFS(board, i+1, j);
        }

        if (j > 0 && board[i][j-1] == 'O') {
            boundaryDFS(board, i, j-1);
        }

        if (j < board[0].length-1 && board[i][j+1] == 'O') {
            boundaryDFS(board, i, j+1);
        }
        return;
    }
}

package LCOF;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: huhao
 * @time: 2020/10/28 11:01
 * @desc:
 */
public class LCOF12_PathInMatrix {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (searchDFS(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean searchDFS(char[][] board, String word, int idx, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx)) {
            return false;
        }

        if (idx == word.length()-1) {
            return true;
        }
        char ch = board[i][j];
        board[i][j] = '/';
        boolean res = searchDFS(board, word, idx+1, i + 1, j) || searchDFS(board, word, idx+1, i - 1, j) ||
                searchDFS(board, word, idx+1, i, j + 1) || searchDFS(board, word,idx+1, i , j - 1);
        board[i][j] = ch;
        return res;
    }
}

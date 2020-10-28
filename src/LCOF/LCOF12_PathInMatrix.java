package LCOF;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: huhao
 * @time: 2020/10/28 11:01
 * @desc: https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 */
public class LCOF12_PathInMatrix {

    /**
     * dfs
     * @param board
     * @param word
     * @return
     */
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
        // 将board[i][j]暂存为ch，并修改字符，代表此元素已访问过，防止之后的搜索重复搜索
        char ch = board[i][j];
        board[i][j] = '/';
        boolean res = searchDFS(board, word, idx+1, i + 1, j) || searchDFS(board, word, idx+1, i - 1, j) ||
                searchDFS(board, word, idx+1, i, j + 1) || searchDFS(board, word,idx+1, i , j - 1);
        // 还原当前元素矩阵
        board[i][j] = ch;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        new LCOF12_PathInMatrix().exist(board, "ABCCED");
    }
}

package leetcode.backtrack;

import java.util.Base64;

/**
 * @author: huhao
 * @time: 2020/12/25 11:01
 * @desc: https://leetcode.com/problems/word-search/
 */
public class M79_WordSearch {

    public boolean exist(char[][] board, String word) {

        char[] wordCharArray = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (backtrack(board, wordCharArray, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, char[] wordCharArray, int idx, int row, int col) {
        // 结束条件
        if (idx == wordCharArray.length) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != wordCharArray[idx]) {
            return false;
        }

        board[row][col] = '*';
        boolean exist = backtrack(board, wordCharArray, idx+1, row-1, col) || backtrack(board, wordCharArray,
                idx+1, row+1, col) || backtrack(board, wordCharArray, idx+1, row, col-1) || backtrack(board, wordCharArray, idx+1, row, col+1);
        // 还原原来的字符
        board[row][col] = wordCharArray[idx];
        return exist;
    }

    public static void main(String[] args) {
        new M79_WordSearch().exist(new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}}, "ABCB");
    }
}

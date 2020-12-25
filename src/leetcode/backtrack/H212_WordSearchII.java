package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/12/25 11:56
 * @desc: https://leetcode.com/problems/word-search-ii/
 */
public class H212_WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> res = new ArrayList<>();

        for (String word : words) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (backtrack(board, i, j, word, 0) && !res.contains(word)) {
                        res.add(word);
                    }
                }
            }
        }
        return res;
    }

    private boolean backtrack(char[][] board, int row, int col, String word, int idx) {

        if (idx == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || word.charAt(idx) !=
                board[row][col]) {
            return false;
        }

        board[row][col] = '*';
        boolean exisit = backtrack(board, row-1, col, word, idx+1) || backtrack(board, row+1, col, word, idx+1)
                ||backtrack(board, row, col-1, word, idx+1) ||backtrack(board, row, col+1, word, idx+1);
        board[row][col] = word.charAt(idx);
        return exisit;
    }
}

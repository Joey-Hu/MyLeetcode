package leetcode.hashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: huhao
 * @time: 2020/10/18 9:56
 * @desc: https://leetcode.com/problems/valid-sudoku/
 */
public class M36_ValidSudoku {
    
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i<9; i++) {
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> block = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !columns.add(board[j][i])) {
                    return false;
                }

                /* 观察行号规律：

                第0个九宫格：000111222; 第1个九宫格：000111222; 第2个九宫格：000111222;

                第3个九宫格：333444555; 第4个九宫格：333444555; 第5个九宫格：333444555;

                第6个九宫格：666777888; 第7个九宫格：666777888; 第8个九宫格：666777888;

                可见对于每三个九宫格行号增3；对于单个九宫格，每三个格点行号增1。

                因此第i个九宫格的第j个格点的行号可表示为i/3*3+j/3 */

                /* 观察列号规律：

                第0个九宫格：012012012; 第1个九宫格：345345345; 第2个九宫格：678678678;

                第3个九宫格：012012012; 第4个九宫格：345345345; 第5个九宫格：678678678;

                第6个九宫格：012012012; 第7个九宫格：345345345; 第8个九宫格：678678678;

                可见对于下个九宫格列号增3，循环周期为3；对于单个九宫格，每个格点行号增1，周期也为3。

                周期的数学表示就是取模运算mod。

                因此第i个九宫格的第j个格点的列号可表示为i%3*3+j%3 */
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                if (board[rowIndex + j/3][colIndex + j%3] != '.' && !block.add(board[rowIndex + j/3][colIndex + j%3])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        new M36_ValidSudoku().isValidSudoku(board);
    }
}

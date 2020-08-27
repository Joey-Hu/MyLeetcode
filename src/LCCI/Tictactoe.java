package LCCI;

/**
 * @author: huhao
 * @time: 2020/8/27 21:23
 * @desc: https://leetcode-cn.com/problems/tic-tac-toe-lcci/
 */
public class Tictactoe {
    /**
     * 平局情况：棋盘填满且无胜者
     * 获胜：存在位于横向、竖向或对角线的同一种符号
     * pending：没有获胜且棋盘没满
     *
     * 用4个数组存储O和X在行和列出现的个数，以及4个变量，O和X在左对角线和右对角线出现的次数。
     * 遍历完后对所有条件进行判断。
     * @param board
     * @return
     */
    public String tictactoe(String[] board) {

        int n = board.length;
        int[] rowx = new int[n];
        int[] colx = new int[n];
        int[] rowo = new int[n];
        int[] colo = new int[n];
        int leftx = 0, rightx = 0, lefto = 0, righto = 0, flag = 0;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(board[i].charAt(j) == 'X'){
                    rowx[i]++;
                    colx[j]++;
                    if(i == j)
                        leftx++;
                    if(i + j + 1 == n)
                        rightx++;
                }else if(board[i].charAt(j) == 'O'){
                    rowo[i]++;
                    colo[j]++;
                    if(i == j)
                        lefto++;
                    if(i + j + 1 == n)
                        righto++;
                }else{
                    flag = 1;
                }
            }
        }
        if(leftx == n || rightx == n) return "X";
        if(lefto == n || righto == n) return "O";

        for(int i = 0; i < n; ++i){
            if(rowx[i] == n || colx[i] == n) return "X";
            if(rowo[i] == n || colo[i] == n) return "O";
        }

        return flag == 1 ? "Pending" : "Draw";
    }
}

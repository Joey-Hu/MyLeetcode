package leetcode.backtrack;

import LCCI.PalindromeLinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/12/25 14:17
 * @desc: https://leetcode.com/problems/n-queens/
 */
public class H51_NQueens {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>();
        // 第 i 个数 queenList[i] 表示在第 i 行，第 queenList[i] 列放 queen
        int[] queenList = new int[n];
        placeQueen(queenList, 0, n, res);
        return res;
    }

    private void placeQueen(int[] queenList, int row, int n, List<List<String>> res) {
        // 结束条件
        if (row == n) {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = "";
                for (int j = 0; j < queenList.length; j++) {
                    if (queenList[i] == j) {
                        str += "Q";
                    }else {
                        str += ".";
                    }
                }
                list.add(str);
            }
            res.add(new ArrayList<>(list));
        }

        // 遍历每一列
        for (int col = 0; col < n; col++) {
            // 判断在该列放 Queen 是否有效
            if (isValid(queenList, row, col)) {
                queenList[row] = col;
                // 递归判断下一行
                placeQueen(queenList, row+1, n, res);
            }
        }
    }

    private boolean isValid(int[] queenList, int row, int col) {

        for (int i = 0; i < row; i++) {
            int pos = queenList[i];
            // 表示该列已存在 Queen
            if (pos == col) {
                return false;
            }

            // 表示在新加入的 Queen 右对角线上存在 Queen （为什么这样表示？？）
            if (pos + row - i == col) {
                return false;
            }

            // 表示在新加入的 Queen 左对角线上存在 Queen
            if (pos -row + i == col) {
                return false;
            }
        }
        return true;
    }
}

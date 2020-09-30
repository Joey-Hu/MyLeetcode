package leetcode.binarysearch_divideAndConquer;

import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/9/30 15:46
 * @desc: https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
 */
public class E1337_TheKWeakestRowsinaMatrix {

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] score = new int[mat.length];
        int i = 0;

        // 这个方法太棒了！！！
        // 将需要的数据作为余数加在score上
        for (int[] row : mat) {
            score[i] = countSoldiers(row) * mat.length + i;
            i ++;
        }

        Arrays.sort(score);
        for (int idx = 0; idx < score.length; idx ++) {
            score[idx] = score[idx] % mat.length;
        }

        return Arrays.copyOfRange(score, 0, k);
    }

    private int countSoldiers(int[] row) {
        int low = 0;
        int high = row.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == 1) {
                low = mid+1;
            }
            if (row[mid] == 0) {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {

        int[][] mat = new int[][] {{1,1,1,1,1}, {1,0,0,0,0}, {1,1,0,0,0}, {1,1,1,1,0}, {1,1,1,1,1}};
        System.out.println(new E1337_TheKWeakestRowsinaMatrix().kWeakestRows(mat, 3));
    }
}

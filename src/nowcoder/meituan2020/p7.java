package nowcoder.meituan2020;

import java.util.Scanner;

/**
 * @author: huhao
 * @time: 2020/12/3 9:43
 * @desc: https://www.nowcoder.com/question/next?pid=21910764&qid=894515&tid=39793132
 */
public class p7 {

    /**
     * N皇后问题 -- 回溯法
     * @param array
     * @param visited
     * @param ans
     * @param curAns
     * @param curProfit
     * @param sum
     * @param row
     */
    public static void backtrack(double[][] array, boolean[] visited, int[] ans, int[] curAns, double curProfit, double
            sum,
                          int row) {
        int len = array.length;
        // 结束条件
        if (row == len) {
            // 更新结果
            if (curProfit > sum) {
                sum = curProfit;
                ans = curAns;
            }
            return;
        }

        // 轮流考虑每一行
        for(int i = 0; i < len; i++) {
            // 该列未选取
            if (!visited[i]) {
                visited[i] = true;
                curProfit += array[row][i];
                curAns[row] = i;
            }

            backtrack(array, visited, ans, curAns, curProfit, sum, row+1);
            visited[i] = false;
            curProfit -= array[row][i];
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        double[][] array = new double[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                double input = scanner.nextDouble();
                array[i][j] = input;
            }
        }

        boolean[] visited = new boolean[array[0].length];
        int[] ans = new int[array[0].length];
        int[] curAns = new int[array[0].length];
        double sum = 0.0;
        backtrack(array, visited, ans, curAns, 0.0, sum, 0);
        System.out.println(sum);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(i+1 + " " + ans[i]+1);
        }
    }
}

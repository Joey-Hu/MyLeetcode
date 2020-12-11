package leetcode.array;

/**
 * @author: huhao
 * @time: 2020/12/11 14:32
 * @desc: https://leetcode.com/problems/image-smoother/
 */
public class E661_ImageSmoother {

    public int[][] imageSmoother2(int[][] M) {
        if (M == null) {
            return null;
        }
        int rows = M.length;
        if (rows == 0) {
            return new int[0][];
        }
        int cols = M[0].length;

        int[][] res = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0;
                int count = 0;
                for (int rowIncre : new int[]{-1, 0, 1}) {
                    for (int colIncre : new int[]{-1, 0, 1}) {
                        if (isValid(i+rowIncre, j+colIncre, rows, cols)) {
                            sum += M[i+rowIncre][j+colIncre];
                            count ++;
                        }
                    }
                }
                res[i][j] = sum / count;
            }
        }
        return res;
    }

    private boolean isValid(int newi, int newj, int rows, int cols) {
        return newi >= 0 && newi < rows && newj >= 0 && newj < cols;
    }

    /**
     * 太臃肿
     * @param M
     * @return
     */
    public int[][] imageSmoother(int[][] M) {
        // 此处必须是深拷贝
        int[][] res = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                res[i][j] = calValue(M, i, j);
            }
        }
        return res;
    }

    public int calValue(int[][] M, int i, int j) {
        int sum = 0;
        int count = 0;
        int rows = M.length;
        int cols = M[0].length;
        if (i-1 >= 0 && j - 1 >= 0) {
            sum += M[i-1][j-1];
            count ++;
        }
        if (i-1 >= 0 && j >= 0) {
            sum += M[i-1][j];
            count ++;
        }
        if (i-1 >= 0 && j+1 <cols) {
            sum += M[i-1][j+1];
            count ++;
        }
        if (i >= 0 && j-1 >= 0) {
            sum += M[i][j-1];
            count ++;
        }
        if (i >= 0 && j >= 0) {
            sum += M[i][j];
            count ++;
        }
        if (i >= 0 && j+1 < cols) {
            sum += M[i][j+1];
            count ++;
        }
        if (i+1 < rows && j-1 >= 0) {
            sum += M[i+1][j-1];
            count ++;
        }
        if (i+1 < rows && j >= 0) {
            sum += M[i+1][j];
            count ++;
        }
        if (i+1 < rows && j+1 < cols) {
            sum += M[i+1][j+1];
            count ++;
        }
        return sum / count;

    }



    public static void main(String[] args) {
        int[][] M = new int[][]{{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
        new E661_ImageSmoother().imageSmoother(M);
    }
}

package LCCI;

public class RotateImage {
    public void rotate(int[][] matrix) {

        // 对角线旋转
        for(int i=0; i<matrix[0].length; i++){
            for(int j = i+1; j<matrix[i].length; j++){
                swap(matrix, i, j, j, i);
            }
        }

        // 首尾列对换
        for(int i=0; i<matrix[0].length; i++){
            for(int j=0; j<matrix[0].length/2; j++){
                swap(matrix, i, j, i, matrix[i].length-j-1);
            }
        }
    }

    public void swap(int[][] matrix, int r1, int c1, int r2, int c2){
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }
}

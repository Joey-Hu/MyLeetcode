package LCCI;

import java.util.HashSet;
import java.util.Set;

public class ZeroMatrix {

//    https://leetcode-cn.com/problems/zero-matrix-lcci/

    public void setZeroes(int[][] matrix) {

        Set<Integer> zeroRow = new HashSet<>();
        Set<Integer> zeroCol = new HashSet<>();


        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j]==0){
                    zeroRow.add(i);
                    zeroCol.add(j);
                }
            }
        }

        for(int i=0; i<matrix.length; i++){
            if(zeroRow.contains(i)){
                for(int j=0; j<matrix[i].length; j++){
                    matrix[i][j] = 0;
                }
            }else {
                for(int j=0; j<matrix[i].length; j++){
                    if(zeroCol.contains(j)){
                        matrix[i][j] = 0;
                    }
                }
            }
        }





    }
}

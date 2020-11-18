package leetcode.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/11/18 14:59
 * @desc: https://leetcode.com/problems/matrix-cells-in-distance-order/
 */
public class E1030_MatrixCellsinDistanceOrder {

    /**
     * 桶排序
     * O(N^2) O(M*N)
     * 首先先将矩阵中每个元素与目标节点的距离放到"桶"中，然后从“桶”中从头开始取元素，其中要注意的是放入桶中时，为了更低的时间复杂度，
     * 需要把元素的(i, j)转化一下
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        List<Integer>[] bucket = new List[R*C];

        int number = 0;
        int distance = 0;
        for (int i = 0; i < R; i ++) {
            for (int j = 0; j < C; j++) {
                number = i * C + j;
                distance = Math.abs(i - r0) + Math.abs(j - c0);
                if (bucket[distance] == null) {
                    bucket[distance] = new ArrayList<>();
                }
                bucket[distance].add(number);
            }
        }
        int idx = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] != null) {
                List list = bucket[i];
                int row = 0;
                int col = 0;
                for (int k = 0; k < list.size(); k++) {
                    row = (int)list.get(k) / C;
                    col = (int)list.get(k) % C;
                    res[idx++] = new int[]{row, col};
                }
            }
        }
        return res;
    }
}

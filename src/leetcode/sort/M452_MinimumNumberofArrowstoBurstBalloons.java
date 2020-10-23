package leetcode.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: huhao
 * @time: 2020/10/21 17:24
 * @desc: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class M452_MinimumNumberofArrowstoBurstBalloons {

    /**
     * 贪心
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
         if (points == null || points.length == 0 || points[0].length == 0) {
             return 0;
         }

         Arrays.sort(points, new Comparator<int[]>() {
             @Override
             public int compare(int[] o1, int[] o2) {
                 return o1[1] > o2[1] ? 1 : -1;
             }
         });

         int arrowPos = points[0][1];
         int minArrows = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos < points[i][0]) {
                arrowPos = points[i][1];
                minArrows ++;
            }
        }
        return minArrows;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{10,16},{2,8},{1,6},{7,12}};
        new M452_MinimumNumberofArrowstoBurstBalloons().findMinArrowShots(points);
    }
}

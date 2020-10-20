package leetcode.hashTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/10/20 11:02
 * @desc: https://leetcode.com/problems/brick-wall/
 */
public class M554_BrickWall {

    /**
     * 记录每行边界长度，穿过最小的砖数量等于length - 边界长度数量最大的个数
     * @param wall
     * @return
     */
    public int leastBricks(List<List<Integer>> wall) {

        Map<Integer, Integer> widthFrequency = new HashMap<>();
        int max = 0;

        for (List<Integer> row : wall) {
            int sum = 0;
            for (int i = 0; i < row.size()-1; i++) {
                sum += row.get(i);
                widthFrequency.put(sum, widthFrequency.getOrDefault(sum, 0)+1);
                max = Math.max(max, widthFrequency.get(sum));
            }
        }
        return wall.size() - max;
    }
}

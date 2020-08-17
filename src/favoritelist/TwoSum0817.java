package favoritelist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/8/17 22:17
 * @desc:
 */
public class TwoSum0817 {
    /**
     * 哈希表方法
     * 思路：先将数组元素值和下标作为key和value存入map,再一次遍历，判断keyset中是否存在target-nums[i]且target-nums[i]的下标
     * 不等于nums[i]的下标
     * 时间复杂度O(N)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i=0; i<nums.length; i++) {
            int component = target - nums[i];
            if (map.keySet().contains(component) && map.get(component)!=i){
                return new int[]{i, map.get(component)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

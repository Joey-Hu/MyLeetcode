package favoritelist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: huhao
 * @time: 2020/8/17 22:17
 * @desc:
 */
public class TwoSum0817I {
    /**
     * 一遍哈希表
     * 思路：遍历数组，同时执行put操作和判断在map已存在的元素中是否有component
     * 时间复杂度：O(N)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int component = target - nums[i];
            if(map.keySet().contains(component)){
                return new int[]{i, map.get(component)};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}

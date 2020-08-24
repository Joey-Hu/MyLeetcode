package LCCI;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: huhao
 * @time: 2020/8/24 15:55
 * @desc: https://leetcode-cn.com/problems/find-majority-element-lcci/
 */
public class FindMajorityElement {
    /**
     * map
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (!map.keySet().contains(nums[i])) {
                map.put(nums[i], 1);
            }else {
                map.put(nums[i], map.get(nums[i])+1);
            }
        }

        for (Integer key : map.keySet()) {
            if (map.get((int)key) > nums.length / 2) {
                return key;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3};
        FindMajorityElement findMajorityElement = new FindMajorityElement();
        findMajorityElement.majorityElement(nums);
    }
}

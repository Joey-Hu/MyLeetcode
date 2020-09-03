package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/8/31 21:04
 * @desc: https://leetcode.com/problems/3sum/
 */
public class ThreeSum {

    /**
     * 第一遍不会
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 排序
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        // 先固定一个数，我们再在后面的数中找符合条件的两个数
        for (int i = 0; i < nums.length-2; i++){
            // 避免重复解  java 中 && 和 || 都是短路与(或)，&& 只要左边不满足，右边就不执行，|| 只要左边满足，右边就不执行
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        // 跳过重复值
                        while (low < high && nums[low] == nums[low + 1]) {
                            low ++;
                        }
                        // 跳过重复值
                        while (low < high && nums[high] == nums[high-1]) {
                            high --;
                        }
                        low ++;
                        high --;
                    } else if(nums[low] + nums[high] < sum) {  // 当nums[low] + nums[high] < sum时，low自增
                        // 跳过重复值
                        while (low < high && nums[low] == nums[low+1]) {
                            low ++;
                        }
                        low ++;
                    }else {  // 当nums[low] + nums[high] < sum时，high自减
                        // 跳过重复值
                        while (low < high && nums[high] == nums[high-1]) {
                            high --;
                        }
                        high --;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new ThreeSum().threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}

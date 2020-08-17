package favoritelist;

/**
 * @author: huhao
 * @time: 2020/8/17 22:17
 * @desc:
 */
public class TwoSum0817II {
    /**
     * 暴力方法
     * 思路：暴力破解--双重循环
     * 时间复杂度：O(N^2)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {


        for (int i=0; i<nums.length; i++) {
            int component = target - nums[i];
            for(int j=0; j<nums.length&&i!=j; j++) {
                if (component == nums[j]) {
                    return new int[] {i, j};
                }
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}

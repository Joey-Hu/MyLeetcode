package leetcode;

/**
 * @author: huhao
 * @time: 2020/9/3 16:34
 * @desc:
 */
public class RemoveDuplicatesfromSortedArray {

    /**
     * 双指针
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}

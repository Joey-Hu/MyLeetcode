package leetcode.array;

/**
 * @author: huhao
 * @time: 2021/3/14 18:16
 * @desc: https://leetcode.com/problems/next-permutation/
 */
public class M31_NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums.length == 1 || nums == null) {
            return;
        }

        int i = nums.length - 2;
        // 从右到左，找到第一个不符合递增趋势的字符nums[i]
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i --;
        }

        if (i >= 0) {
            int j = i + 1;
            // 从右到左找到第一个大于nums[i]的字符nums[j]
            while (j < nums.length && nums[i] > nums[j]) {
                j ++;
            }
            j --;
            // 交换nums[i] 和 nums[j]
            swap(nums, i, j);
        }
        // 逆转nums[i]右边的字符，使其递增
        reverse(nums, i+1, nums.length-1);

    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

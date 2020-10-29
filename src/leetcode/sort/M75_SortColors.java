package leetcode.sort;

/**
 * @author: huhao
 * @time: 2020/10/21 11:18
 * @desc: https://leetcode.com/problems/sort-colors/
 */
public class M75_SortColors {

    /**
     * 快速排序
     * @param nums
     */
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int index = getIndex(nums, low, high);

            quickSort(nums, low, index-1);
            quickSort(nums, index+1, high);
        }
    }

    private int getIndex(int[] nums, int low, int high) {
        int temp = nums[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && nums[high] >= temp) {
                high --;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            nums[low] = nums[high];

            // 当队首元素小于等于tmp时,向后挪动low指针
            while (low < high && nums[low] <= temp) {
                low ++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
    }
}

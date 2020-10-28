package leetcode.binarysearch_divideAndConquer;

/**
 * @author: huhao
 * @time: 2020/10/10 9:43
 * @desc: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class M153_FindMinimuminRotatedSortedArray {

    /**
     * 更加完整
     * @param numbers
     * @return
     */
    public int findMin2(int[] numbers) {
        int low = 0;
        int high = numbers.length-1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            }else if (numbers[mid] < numbers[high]) {
                high = mid;
            } else {
                // 由于重复元素的存在，我们并不能确定最小值究竟在最小值的左侧还是右侧，
                // 因此我们不能莽撞地忽略某一部分的元素，改为线性查找
                int x = low;
                for(int k = low + 1; k < high; k++) {
                    if(numbers[k] < numbers[x]) x = k;
                }
                return numbers[x];
            }
        }
        return numbers[low];
    }

    /**
     * 注意条件
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return nums[low];
    }
}

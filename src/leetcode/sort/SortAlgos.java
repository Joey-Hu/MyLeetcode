package leetcode.sort;

/**
 * @author: huhao
 * @time: 2020/11/10 8:17
 * @desc: https://www.cnblogs.com/onepixel/articles/7674659.html
 */
public class SortAlgos {

    /**
     * 快速排序
     * 时间复杂度：O(NlgN)
     * 空间复杂度：O(1)
     * 步骤：
     *  1. 挑选基准值
     *  2. 分割：重新排列数组，把比基准值小的元素放到基准值前面，比基准值大的元素放到基准值后面
     *  3. 递归排列子序列
     * @param nums
     * @param left
     * @param right
     */
    public void quickSort(int[] nums, int left, int right) {

        // 结束条件
        if (left >= right) {
            return;
        }

        int i = left;
        int j = right;
        int key = nums[left];
        while (i < j) {
            while (i < j && nums[j] > key) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] < key) {
                i ++;
            }
            nums[j] = nums[i];
        }
        nums[i] = key;
        quickSort(nums, left, i-1);
        quickSort(nums, i+1, right);
    }


    public void mergeSort(int[] nums, int left, int right, int[] temp) {
        // 结束条件
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        // 对左边子序列进行归并排序
        mergeSort(nums, left, mid, temp);
        // 对右边子序列进行归并排序
        mergeSort(nums, mid+1, right, temp);
        // 合并
        merge(nums, left, mid, right, temp);
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[t++] = nums[i++];
            }else {
                temp[t++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = nums[i++];
        }

        while (j <= right) {
            temp[t++] = nums[j++];
        }

        // 将temp中的元素全部拷贝到原数组中
        for (int k = 0; k < temp.length; k++) {
            nums[left++] = temp[k++];
        }

    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 7, 4, 8};
        SortAlgos sortAlgos = new SortAlgos();
//        sortAlgos.quickSort(nums, 0, nums.length-1);
        sortAlgos.mergeSort(nums, 0, nums.length-1, new int[nums.length]);
        for (int num : nums) {
            System.out.print(num);
        }

    }
}

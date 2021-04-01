package leetcode.sort;

import java.util.Arrays;

/**
 * @author: huhao
 * @time: 2020/11/10 8:17
 * @desc: https://www.cnblogs.com/onepixel/articles/7674659.html
 */
public class SortAlgorithms {

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
            // 把小于基准值的元素放到前面
            while (i < j && nums[j] >= key) {
                j--;
            }
            nums[i] = nums[j];
            // 把大于基准值的元素放到后面
            while (i < j && nums[i] <= key) {
                i ++;
            }
            nums[j] = nums[i];
        }
        nums[i] = key;
        quickSort(nums, left, i-1);
        quickSort(nums, i+1, right);
    }


    /**
     * 归并排序
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(N)
     * 步骤：先分后合
     * @param nums
     * @param left
     * @param right
     * @param temp
     */
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
        t = 0;
        // 将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            nums[left++] = temp[t++];
        }
    }

    /**
     * 插入排序
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * 步骤：从第二个元素开始，逐个将后面的元素插入到前面的有序子序列中
     * @param nums
     */
    private void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * 步骤：将较大的元素逐个上升放到末尾
     * @param nums
     */
    private void bubbleSort(int[] nums) {
        boolean isSwaped;
        for (int i = nums.length-1; i > 0; i--) {
            isSwaped = false;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                    isSwaped = true;
                }
            }
            if (!isSwaped) {
                break;
            }
        }
    }

    /**
     * 选择排序
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * 步骤：从第一个数 i 开始，逐个从 i 后面的序列中找到最小的数min，并与 i 交换
     * @param nums
     */
    private void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            int min = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }

            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
        }
    }



    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 7, 4, 8};
        SortAlgorithms sortAlgos = new SortAlgorithms();
//        sortAlgos.quickSort(nums, 0, nums.length-1);
//        sortAlgos.mergeSort(nums, 0, nums.length-1, new int[nums.length]);
//        sortAlgos.insertSort(nums);
//        sortAlgos.bubbleSort(nums);
        sortAlgos.selectionSort(nums);
        for (int num : nums) {
            System.out.print(num);
        }

    }
}

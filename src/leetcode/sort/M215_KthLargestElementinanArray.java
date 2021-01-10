package leetcode.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: huhao
 * @time: 2020/9/6 15:45
 * @desc: https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class M215_KthLargestElementinanArray {

    /**
     * 使用最大堆（优先队列实现）
     * 建立一个大小为 len-k+1 的最大堆
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest3(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(nums.length - k + 1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < nums.length; i ++) {
            if (maxHeap.size() < nums.length - k + 1) {
                maxHeap.offer(nums[i]);
            }else if (maxHeap.peek() > nums[i]) {
                maxHeap.poll();
                maxHeap.offer(nums[i]);
            }
        }

        return maxHeap.poll();
    }

    /**
     * 快速选择(快速排序思想)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int pos = partition(nums, left, right);
            if (pos == nums.length - k) {
                break;
            }else if (pos > nums.length - k) {
                right = pos - 1;
            }else {
                left = pos + 1;
            }
        }
        return nums[nums.length - k];
    }

    private int partition(int[] a, int l, int r) {
        int left = l;
        int right = r;

        while (left < right) {
            // 分治，把所有大于等于pivot的元素移到右边，所有小于等于pivot的元素移到左边
            while (right > l && a[right] > a[l]) {
                right --;
            }
            while (left < r && a[left] < a[l]) {
                left ++;
            }
            swap(a, left, right);
        }
        swap(a, l, right);
        return right;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]  =temp;
    }

    /**
     * quick sort
     * O(NlogN)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(new M215_KthLargestElementinanArray().findKthLargest2(nums, 2));
    }
}

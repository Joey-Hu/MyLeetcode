package LCCI;

/**
 * @author: huhao
 * @time: 2020/8/27 16:53
 * @desc: https://leetcode-cn.com/problems/search-rotate-array-lcci/
 */
public class SearchRotateArray {

    /**
     * 二分查找（针对有序结构数据）
     * 二分查找模板(假设是升序) -- 递归实现
     * public int binarySearch(int[] arr, int target, int left, int right) {
     *     if (left > right) {
     *         return -1;
     *     }
     *
     *     int mid = left + (right - left) / 2;
     *     if (target < arr[mid]) {
     *         return binarySearch(arr, target, left, mid);
     *     } else if (target > arr[mid]) {
     *         return binarySearch(arr, target, mid + 1, right);
     *     } else {
     *         return mid;
     *     }
     *     return -1;
     * }
     * @param arr
     * @param target
     * @return
     */


    public int search(int[] arr, int target) {

        if (arr.length == 0) {
            return -1;
        }

        return bianrySearch(arr, target, 0, arr.length-1);
    }

    private int bianrySearch(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        if (left == right) {
            if (target == arr[left]) {
                return left;
            }else {
                return -1;
            }
        }

        int mid = left + (right - left) / 2;
        // 如果左区间为升序的话
        if (arr[left] < arr[mid]) {
            //target在左区间范围
            if (target <= arr[mid] && target >= arr[left]) {
                return bianrySearch(arr, target, left, mid);
            }else {
                return bianrySearch(arr, target, mid + 1, right);
            }
        } else if (arr[left] > arr[mid]) {            // 如果左区间为不为升序的话
            //还是以左区间搜索为优先, 如果条件成立，target还是在左区间中
            if (target <= arr[mid] || target >= arr[left]) {
                return bianrySearch(arr, target, left, mid);
            }else {
                return bianrySearch(arr, target, mid + 1, right);
            }
        } else {    // 当arr[left] == arr[mid], 左右两端都要找
            int res = bianrySearch(arr, target, left, mid);
            if (res == -1) {
                return bianrySearch(arr, target, mid + 1, right);
            }else {
                return res;
            }
        }
    }

}

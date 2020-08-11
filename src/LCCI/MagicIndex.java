package LCCI;

/**
 * @author: huhao
 * @time: 2020/8/11 21:59
 * @desc:  https://leetcode-cn.com/problems/magic-index-lcci
 */
public class MagicIndex {
    /**
     * 暴力解法 O(n)
     * @param nums
     * @return
     */
    public int findMagicIndex(int[] nums) {

        for (int i=0; i<nums.length; i++){
            if (nums[i] == i){
                return i;
            }
        }
        return -1;
    }

    /**
     * 有序列表查找就要想到二分法
     * 二分查找 O(log N)
     * @param nums
     * @return
     */
    public int findMagicIndex2(int[] nums) {

        return getAnswer(nums, 0, nums.length-1);
    }

    private int getAnswer(int[] nums, int left, int right) {
        if(left>right){
            return -1;
        }

        int mid = (right - left) / 2 + left;
        int leftAnswer = getAnswer(nums, left, mid-1);
        if(leftAnswer != -1){
            return leftAnswer;
        }else if(nums[mid] == mid){
            return mid;
        }
        return getAnswer(nums, mid+1, right);
    }

    /**
     * 跳跃法
     * @param nums
     * @return
     */
    public int findMagicIndex3(int[] nums) {

        int index = 0;
        while(index < nums.length){
            if(nums[index] == index){
                return index;
            }
            if(nums[index] > index){
                index = nums[index];
            }
            else {
                index++;
            }
        }
        return -1;
    }
}

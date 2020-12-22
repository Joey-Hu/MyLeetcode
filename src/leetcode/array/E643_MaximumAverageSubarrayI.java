package leetcode.array;

/**
 * @author: huhao
 * @time: 2020/12/22 21:27
 * @desc: https://leetcode.com/problems/maximum-average-subarray-i/
 */
public class E643_MaximumAverageSubarrayI {

    /**
     * 1. 双重循环 O(N^2)
     * 2. slide window 用一个数组来保存k个数的和
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        int[] kSum = new int[nums.length-k+1];

        int idx = 0;
        int i = 0;
        int sum = 0;


        while (i < k) {
            sum += nums[i++];
        }
        kSum[idx++] = sum;

        while (i < nums.length) {
            sum = sum - nums[i-k] + nums[i];
            kSum[idx++] = sum;
            i++;
        }

        double maxAvg = kSum[0]*1.0/k;
        for (int j = 1; j < kSum.length; j++) {
            maxAvg = Math.max(maxAvg, kSum[j]*1.0/k);

        }

        return maxAvg;
    }

    public static void main(String[] args) {
        new E643_MaximumAverageSubarrayI().findMaxAverage(new int[]{4,2,1,3,3}, 2);
    }
}

package leetcode.array;

/**
 * @author: huhao
 * @time: 2021/3/18 13:10
 * @desc:
 */
public class H41_FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 将所有小于 0 或者是大于 n 的元素都标记成 n+1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // 将nums[nums[i]-1]变成负数用来表示该索引代表的数出现过
        for (int i = 0; i < n; i++) {
            // 为了防止重复元素的出现，由于之前已经出现过，所以此时的nums[i]被标记成负数，等到再次出现时，需要进行绝对值处理
            int num = Math.abs(nums[i]);
            if (num > n) {
                continue;
            }
            num --;
            if (nums[num] > 0) {
                nums[num] = -1 * nums[num];
            }
        }
        // 找到第一个为正数的元素，该元素的下标代表的数就是缺失的第一个正数
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }

        // 如果没有找到正数索引，表示nums中包含1...n所有元素
        return n + 1;
    }
    public static void main(String[] args) {
        int nums[] = {-1,4,2,4,9,10};
        new H41_FirstMissingPositive().firstMissingPositive(nums);
    }
}

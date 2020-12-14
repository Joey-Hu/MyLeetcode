package leetcode.greedy;

/**
 * @author: huhao
 * @time: 2020/12/11 19:14
 * @desc: https://leetcode.com/problems/candy/
 */
public class H135_Candy {

    /**
     * 双侧扫描
     * 贪心策略：每次只考虑并更新相邻一侧的大小关系
     * 初始化：把所有孩子的糖果数初始化为1
     * 从左往右遍历：如果右边孩子的评分比左边的高，则右边孩子的糖果数更新为左边孩子的糖果数加1；
     * 再从右往左遍历一遍，如果左边孩子的评分比右边的高，且左边孩子当前的糖果数不大于右边孩子的糖果数，
     * 则左边孩子的糖果数更新为右边孩子的糖果数加1
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {

        int[] candies = new int[ratings.length];
        int res = 0;

        for (int i = 0; i < candies.length; i++) {
            candies[i] = 1;
        }

        for (int i = 1; i < candies.length; i++) {
            if (ratings[i-1] < ratings[i]) {
                candies[i] = candies[i-1]+1;
            }
        }

        for (int i = candies.length-1; i >= 1 ; i--) {
            if (ratings[i-1] > ratings[i] && candies[i-1] <= candies[i]) {
                candies[i-1] = candies[i] + 1;
            }
        }

        for (int i = 0; i< candies.length; i++) {
            res += candies[i];
        }
        return res;
    }
}

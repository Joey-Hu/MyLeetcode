package leetcode.array;

/**
 * @author: huhao
 * @time: 2020/9/12 11:17
 * @desc: https://leetcode.com/problems/count-number-of-teams/
 */
public class CountNumberofTeams {
    /**
     * 暴力解法
     * O(n^3)
     * @param rating
     * @return
     */
    public int numTeams(int[] rating) {
        int count = 0;
        for (int i = 0; i < rating.length-2; i++) {
            for (int j = i+1; j < rating.length-1; j++) {
                if (rating[i] > rating[j]) {
                    for (int k = j+1; k < rating.length; k++) {
                        if (rating[k] < rating[j]) {
                            count ++;
                        }
                    }
                } else if (rating[i] < rating[j]) {
                    for (int k = j+1; k < rating.length; k++) {
                        if (rating[k] > rating[j]) {
                            count ++;
                        }
                    }
                }
            }
        }
        return count;
    }

    /**
     * 把rating[i]  放在中间，分别求出左边比其大和比其小的数的个数，再求出右边边比其大和比其小的数的个数，
     * 最后左边小的个数*右边大的个数+左边大的个数*右边小的个数，即为rating[i]放在三个人的中间时可以组成的排列数的总数。
     * @param rating
     * @return
     */
    public int numTeams2(int[] rating) {
        int res = 0;

        for (int i = 1; i < rating.length - 1; i++) {
            int leftSamll = 0;
            int leftGreat = 0;
            for (int j = 0; j < i; j++) {
                if (rating[i] > rating[j]) {
                    leftSamll ++;
                }
                if (rating[i] < rating[j]) {
                    leftGreat ++;
                }
            }
            int rightSamll = 0;
            int rightGreat = 0;
            for (int j = i+1; j < rating.length; j++) {
                if (rating[i] > rating[j]) {
                    rightSamll ++;
                }
                if (rating[i] < rating[j]) {
                    rightGreat ++;
                }
            }
            res += leftSamll * rightGreat + leftGreat * rightSamll;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] rating = new int[]{2,5,3,4,1};
        new CountNumberofTeams().numTeams(rating);
    }
}

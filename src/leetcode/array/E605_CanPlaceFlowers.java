package leetcode.array;

/**
 * @author: huhao
 * @time: 2020/11/25 15:47
 * @desc: https://leetcode.com/problems/can-place-flowers/
 */
public class E605_CanPlaceFlowers {

    /**
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        return count >= n;
    }
}

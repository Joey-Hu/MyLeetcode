package LCCI;

/**
 * @author: huhao
 * @time: 2020/8/24 9:17
 * @desc: https://leetcode-cn.com/problems/coin-lcci/
 */
public class Coin{

    /**
     * 动态规划
     * 背包问题 是经典的动态规划问题
     * https://leetcode-cn.com/problems/coin-lcci/solution/bei-bao-jiu-jiang-ge-ren-yi-jian-da-jia-fen-xiang-/
     * https://leetcode-cn.com/problems/coin-lcci/solution/dong-tai-gui-hua-wan-quan-bei-bao-wen-ti-by-eddiev/
     * O（N）
     * @param n
     * @return
     */
    public int waysToChange(int n) {
        int[] res = new int[n+1];
        int[] coin = new int[]{1,5,10,25};

        res[0] = 1;

        for (int i=0; i<coin.length; i++){
            for (int j=1; j<=n; j++){
                if (j >= coin[i]){
                    res[j] = (res[j] + res[j-coin[i]]) % 1000000007;
                }
            }
        }
        return res[n];
    }

    public static void main(String[] args) {
        Coin coin = new Coin();
        System.out.println(coin.waysToChange(61));
    }

}

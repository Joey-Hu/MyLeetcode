package nowcoder.vivo2020;

/**
 * @author: huhao
 * @time: 2020/9/19 21:07
 * @desc: https://www.nowcoder.com/question/next?pid=22390442&qid=925106&tid=37756688
 */
public class p3 {

    /**
     * 思路太牛了！！！
     * @param n
     * @return
     */
    public int solution (int n) {
        int res = 0;
        int i= 1;
        while (n > 0) {
            res += i * Math.min(i, n);
            n -= i;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        new p3().solution(5);
    }
}

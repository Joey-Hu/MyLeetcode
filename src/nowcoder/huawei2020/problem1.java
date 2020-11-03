package nowcoder.huawei2020;

import java.util.Scanner;

/**
 * @author: huhao
 * @time: 2020/11/3 10:16
 * @desc: https://www.nowcoder.com/test/question/fe298c55694f4ed39e256170ff2c205f?pid=1088888&tid=39117847
 */
public class problem1 {
    public static int numOfDrinks(int num) {
        int res = 0;
        if (num > 0) {
            while (num > 1) {
                res += num / 3;
                num = num / 3 + num % 3;
                if (num == 2) {
                    num ++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            System.out.println(numOfDrinks(num));
        }
    }
}

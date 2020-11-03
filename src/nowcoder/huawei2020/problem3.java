package nowcoder.huawei2020;

import java.util.Scanner;

/**
 * @author: huhao
 * @time: 2020/11/3 10:21
 * @desc: https://www.nowcoder.com/question/next?pid=1088888&qid=36827&tid=39117847
 */
public class problem3 {
    public static int hex2dec(String str) {
        int  res = 0;
        int pow = 0;
        for (int i = str.length()-1; i > 1; i--) {
            char ch = str.charAt(i);
            int num = 0;
            if (ch >= 'A' &&  ch <= 'F') {
                num = ch - 'A' + 10;
            }else if (ch >= '0' &&  ch <= '9'){
                num = ch - '0';
            }else {
                System.out.println("不是16进制形式。");
                return -1;
            }
            res = (int) (res  + num * Math.pow(16, pow));
            pow ++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.next();
            System.out.println(hex2dec(str));
        }
    }
}

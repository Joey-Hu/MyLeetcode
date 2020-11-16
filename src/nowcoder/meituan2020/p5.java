package nowcoder.meituan2020;

import java.util.Scanner;

/**
 * @author: huhao
 * @time: 2020/11/16 20:40
 * @desc:
 */
public class p5 {

    private static String expressionEvaluate(String str) {
        String[] strSplit = str.split(" ");
        int len = strSplit.length;
        int[] arr = new int[len]; // 转成整数比较快
        if (len % 2 == 0) {
            return "error";
        }

        String exp;
        char c;
        // 转整数，并且判断字符串是否合法
        for (int i = 0; i < len; i++) {
            exp = strSplit[i];
            c = exp.charAt(0);
            if (i % 2 == 0) {
                if (c == 't') {
                    arr[i] = 1;
                }else if (c == 'f') {
                    arr[i] = 0;
                }else {
                    return "error";
                }
            }else {
                if (c == 'o') {
                    arr[i] = 3;
                }else if (c == 'a') {
                    arr[i] = 2;
                }else {
                    return "error";
                }
            }
        }

        // 处理and
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==2){
                if (arr[i-1]+arr[i+1]<2){
                    arr[i-1]=0;
                    arr[i+1]=0;
                }
            }
        }

        //存在一个true即返回true，因为现在只有or，一个true或上任何值都是true
        for (int i=0;i<len;i+=2){
            if (arr[i]==1) {
                return "true";
            }
        }
        return "true";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.next();
            expressionEvaluate(str);
        }
    }
}

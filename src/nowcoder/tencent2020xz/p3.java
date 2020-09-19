package nowcoder.tencent2020xz;

import java.util.Scanner;

/**
 * @author: huhao
 * @time: 2020/9/19 20:34
 * @desc: https://www.nowcoder.com/question/next?pid=21283868&qid=830862&tid=37736188
 */
public class p3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int lenOfVocation = scanner.nextInt();

        int[] company = new int[lenOfVocation];
        int[] gym = new int[lenOfVocation];

        for (int i = 0; i < lenOfVocation; i++) {
            company[i] = scanner.nextInt();
        }

        for (int i = 0; i < lenOfVocation; i++) {
            gym[i] = scanner.nextInt();
        }




    }


}

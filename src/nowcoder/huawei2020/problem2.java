package nowcoder.huawei2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author: huhao
 * @time: 2020/11/3 10:48
 * @desc: https://www.nowcoder.com/question/next?pid=1088888&qid=36829&tid=39118312
 */
public class problem2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int amount = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < amount; i++) {
                int num = sc.nextInt();
                if (!list.contains(num)) {
                    list.add(num);
                }
            }
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }
}

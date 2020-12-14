package leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/8 15:35
 * @desc: https://leetcode.com/problems/pascals-triangle/
 */
public class E118_PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();

        if (numRows == 1) {
            List<Integer> list1 = new ArrayList<>();
            list1.add(1);
            res.add(list1);
            return res;
        }

        if (numRows == 2) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            list1.add(1);
            res.add(list1);
            list2.add(1);
            list2.add(1);
            res.add(list2);
            return res;
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        res.add(list1);
        list2.add(1);
        list2.add(1);
        res.add(list2);

        for (int i = 3; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i - 1; j++) {
                list.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }
}

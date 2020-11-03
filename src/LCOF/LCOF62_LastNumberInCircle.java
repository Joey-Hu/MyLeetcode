package LCOF;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/11/2 9:23
 * @desc: https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 */
public class LCOF62_LastNumberInCircle {

    /**
     * 列表 + 求余
     * 约瑟夫环
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (list.size() > 1) {
            idx = (idx + m - 1) % list.size();
            list.remove(idx);
        }
        return list.get(0);
    }
}

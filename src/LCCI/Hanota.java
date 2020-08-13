package LCCI;

import java.util.List;

/**
 * @author: huhao
 * @time: 2020/8/13 20:15
 * @desc: https://leetcode-cn.com/problems/hanota-lcci/
 */
public class Hanota {
    /**
     * 递归 + 分支
     * 当N = 2时，我们先将一个小盘移到B，将大盘从A移到C,再将小盘从B移到C
     * 当N > 2时，采用分治方法，将除了最大的盘看做大盘，其余盘看做一个整体，为小盘，这样就抽像为N=2的情形；
     * 那如何将N-1个盘移到C呢？这就是上面问题的子问题了，可以采用递归方法解决
     * @param A
     * @param B
     * @param C
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {

        int size = A.size();
        move(size, A, B, C);
    }

    private void move(int size, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (size == 1){
            C.add(A.get(A.size()-1));
            A.remove(A.size()-1);
            return;
        }

        // N-1个盘经过辅助C放到B上
        move(size-1, A, C, B);
        // 大盘从A放到C
        C.add(A.get(A.size()-1));
        A.remove(A.size()-1);
        // B经过辅助A放到C上
        move(size-1, B, A, C);
    }
}

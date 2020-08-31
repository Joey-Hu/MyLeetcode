package LCCI;

import com.sun.org.apache.bcel.internal.generic.BALOAD;
import javafx.geometry.Pos;

import java.util.*;

/**
 * @author: huhao
 * @time: 2020/8/31 14:25
 * @desc: https://leetcode-cn.com/problems/langtons-ant-lcci/
 */
public class LangtonsAnt {
    /**
     *
     * @param K
     * @return
     */
    public List<String> printKMoves(int K) {

        char[] direction = {'L', 'U', 'R', 'D'};
        // 用“向量”记录方向，顺序与上一行方向的字符顺序保持一致，每个元素的后一个元素都是可以90°向右变换得到的
        int[][] offset = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        // 蚂蚁的位置
        Position antPos = new Position(0, 0);
        // 蚂蚁的方向向量  初始向右
        int antDir = 2;
        // 存储黑块的set集合
        Set<Position> blackSet = new HashSet<>();

        while (K > 0) {
            // 新的坐标对象用于放入集合
            Position t = new Position(antPos.x, antPos.y);
            // 如果能存入集合，表示该位置是白色，翻转颜色，方向序号循环自增1
            if (blackSet.add(t)) {
                antDir = (antDir + 1) % 4;
            }else {
                // 如果不能存入集合，表示该位置是黑色，翻转颜色，方向序号循环自增3
                antDir = (antDir + 3) % 4;
                blackSet .remove(t);
            }
            // 移动
            antPos.x = offset[antDir][0];
            antPos.y = offset[antDir][1];
            K --;
        }

        int left = antPos.x;
        int top = antPos.y;
        int right = antPos.x;
        int bottom = antPos.y;

        for (Position position : blackSet) {
            left = position.x < left ? position.x : left;
            top = position.y < top ? position.y : top;
            right = position.x > right ? position.x : right;
            bottom = position.y > bottom ? position.y : bottom;
        }
        char[][] grid = new char[bottom - top + 1][right - left + 1];

        for (char[] row : grid) {
            Arrays.fill(row, '_');
        }

        for (Position pos : blackSet) {
            grid[pos.y - top][pos.x - left] = 'X';
        }

        grid[antPos.y - top][antPos.x - left] = direction[antDir];

        List<String> result = new ArrayList<>();
        for (char[] row : grid) {
            result.add(String.valueOf(row));
        }
        return result;







    }

    private class Position {

        /**
         * 横纵坐标
         */
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Position position = (Position) o;
            return x == position.x &&
                    y == position.y;
        }

        /**
         * 改写哈希算法，使两个 Position 对象可以比较坐标而不是内存地址
         */
        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}

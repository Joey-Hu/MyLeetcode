//package LCCI;
//
//import com.sun.javafx.geom.Vec2d;
//
//import java.util.*;
//
///**
// * @author: huhao
// * @time: 2020/8/25 21:28
// * @desc: https://leetcode-cn.com/problems/pond-sizes-lcci/
// */
//public class PondSizes2 {
//
//    /**
//     * 广度优先搜索 -- BFS
//     * @param land
//     * @return
//     */
//
//    int[][] visited;
//    int row;
//    int col;
//    int[][] move = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
//    Queue<int[]> queue = new LinkedList<>();
//
//    class Point{
//        int x;
//        int y;
//    }
//
////    public int[] pondSizes(int[][] land) {
////
////        row = land.length;
////        col = land[0].length;
////        visited = new int[row][col];
////        List<Integer> res = new ArrayList<>();
////
////        for (int i = 0; i < row; i++) {
////            for (int j = 0; j < col; j++) {
//////                int size = bfs(land, i, j);
////                if (size > 0) {
////                    res.add(size);
////                }
////            }
////        }
//
//        // 返回结果
//        Collections.sort(res);
//        int[] ans = new int[res.size()];
//
//        for (int i = 0; i < res.size(); i++) {
//            ans[i] = res.get(i);
//        }
//
//        return ans;
//    }
//
////    private int bfs(int[][] land, int i, int j) {
////        queue.offer(new int[]{i, j});
////        land[i][j] = 1;
////
////    }
//
//    private int dfs(int[][] land, int x, int y) {
//        if (x < 0 || x >= row || y < 0 || y >= col || land[x][y] > 0 || visited[x][y] == 1){
//            return 0;
//        }
//        visited[x][y] = 1;
//        int res = 1;
//
//        // 向8个方向移动
//        for (int i = 0; i < 8; i++) {
//            int nx = x + move[i][0];
//            int ny = y + move[i][1];
//            res += dfs(land, nx, ny);
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//        int[][] land = new int[][]{{0,2,1,0},{0,1,0,1},{1,1,0,1},{0,1,0,1}};
//        new PondSizes2().pondSizes(land);
//
//    }
//
//}

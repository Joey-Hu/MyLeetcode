package LCCI;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: huhao
 * @time: 2020/7/7 14:27
 * @desc: https://leetcode-cn.com/problems/route-between-nodes-lcci/
 */
public class RouteBetweenNodes {
    /**
     * 邻接表 + DFS / BFS
     */

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {

        // 构建邻接表
        List<Integer>[] adj = new ArrayList[n];
        for(int[] edge : graph){
            if(edge!=null){
                int from = edge[0];
                int to = edge[1];
                if(adj[from] == null){
                    adj[from] = new ArrayList<>();
                }
                adj[from].add(to);
            }
        }

        boolean[] visited = new boolean[n];

        return dfs(adj, visited, start, target);

    }

    private boolean dfs(List<Integer>[] adj, boolean[] visited, int start, int target) {
        if(start == target){
            return true;
        }

        visited[start] = true;
        List<Integer> nexts = adj[start];
        if(nexts == null){
            return false;
        }
        for(int next : nexts){
            if(visited[next]){
                continue;
            }
            if(dfs(adj, visited, next, target)){
                return true;
            }
        }
        return false;
    }

    private boolean bfs(List<Integer>[] adj, boolean[] visited, int start, int target) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(start); // Adds the specified element as the tail (last element) of this list.
        visited[start] = true;

        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int node = queue.poll(); // Retrieves and removes the head (first element) of this list.
                List<Integer> nexts = adj[node];
                if(nexts == null){
                    return false;
                }

                for(int next : nexts){
                    if(next == target){
                        return true;
                    }

                    if(visited[next]){
                        continue;
                    }
                    visited[next] = true;
                    queue.add(next); // Appends the specified element to the end of this list.
                }
            }
        }
        return false;
    }
}

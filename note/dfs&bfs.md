#### lc200 岛屿数量

深度优先遍历，当遍历到某个位置grid\[i][j] 时，判断结果为1时，res ++，并标记该元素已访问过，然后进行深度优先遍历其周围的元素

注意终止条件

```java
/**
 * DFS
 * @param grid
 * @return
 */
public int numIslands(char[][] grid) {
    int res = 0;
    int rows = grid.length;
    int cols = grid[0].length;

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (grid[i][j] == '1') {
                boundaryDFS(grid, i, j);
                res++;
            }
        }
    }
    return res;
}

private void boundaryDFS(char[][] grid, int i, int j) {
    // terminal condition
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
        return;
    }
    // 标记已访问过的元素
    if (grid[i][j] == '1') {
        grid[i][j] = '*';
    }
    // 深度遍历未访问过的元素
    if (i > 0 && grid[i-1][j] == '1') {
        boundaryDFS(grid, i-1, j);
    }

    if (i < grid.length-1 && grid[i+1][j] == '1') {
        boundaryDFS(grid, i+1, j);
    }

    if (j > 0 && grid[i][j-1] == '1') {
        boundaryDFS(grid, i, j-1);
    }

    if (j < grid[0].length-1 && grid[i][j+1] == '1') {
        boundaryDFS(grid, i, j+1);
    }
    return;
}
```
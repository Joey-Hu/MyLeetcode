#### lc200 岛屿数量

```java
/**
 * DFS
 * 逐行遍历，遇见 1 就将其与周边的 1 都变成 *, res ++
 * similar questions: Surrounded Regions, Max Area of Island
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
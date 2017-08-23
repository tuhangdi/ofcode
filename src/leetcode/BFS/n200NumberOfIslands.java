package leetcode.BFS;

/**
 * Created by thd on 2017/8/23
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 给定“1（土地）”和“0”（水）的二维网格图，计算岛屿数量。 海岛被水围绕，并且通过水平或垂直连接相邻的陆地而形成。 您可以假设网格的所有四个边缘都被水包围。
 Example 1:

 11110
 11010
 11000
 00000
 Answer: 1

 Example 2:

 11000
 11000
 00100
 00011
 Answer: 3

 */
public class n200NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid.length == 0 || grid == null) return count;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1')
            return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}

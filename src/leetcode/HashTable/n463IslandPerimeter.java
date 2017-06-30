package leetcode.HashTable;

/**
 * Created by thd on 2017/6/27.
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 * 给出一个二维整数网格形式的地图，其中1表示土地，0表示水。
 * 网格单元水平/垂直（不对角线）连接。 网格完全被水包围，并且正好有一个岛（即，一个或多个连接的地面细胞）。
 * 岛上没有“湖泊”（水内没有连接到岛上的水）。
 * 一个单元格是具有边长为1的正方形。网格为矩形，宽度和高度不超过100.
 * 确定岛的周长。
 *
 * Example:

 [[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

 Answer: 16
 */
public class n463IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0 || grid == null) return 0;
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result += 4;
                    if (i > 0 && grid[i - 1][j] == 1) result -= 2;
                    if (j > 0 && grid[i][j - 1] == 1) result -= 2;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid =  {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
        n463IslandPerimeter n = new n463IslandPerimeter();
        System.out.println(n.islandPerimeter(grid));
    }
}

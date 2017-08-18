package leetcode.Array;

import org.junit.jupiter.api.Test;

/**
 * Created by thd on 2017/8/18
 *
 *
 Given a 2D board and a word, find if the word exists in the grid.
 给定一个2D板和一个单词，找出这个单词是否存在于网格中。
 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 该单词可以由顺序相邻单元的字母构成，其中“相邻”单元是水平或垂直相邻的单元。 相同的字母单元可能不会被多次使用。
 For example,
 Given board =

 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.

 */
public class n79WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && serach(board, visited, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean serach(char[][] board, boolean[][] visited, String word, int i, int j, int index) {
        if (index == word.length())
            return true;
        if (i >= board.length || i < 0 || j >= board[i].length || j < 0
                || board[i][j] != word.charAt(index) || visited[i][j])
            return false;
        visited[i][j] = true;
        if (serach(board, visited, word,i - 1, j, index + 1) || serach(board, visited, word, i + 1, j, index + 1)
                || serach(board, visited, word, i, j - 1, index + 1) || serach(board, visited, word, i, j + 1, index + 1))
            return true;

        visited[i][j] = false;
        return false;
    }

    @Test
    public void test() {
        char[][] b =  {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String s = "ABCCED";
        System.out.println(exist(b, s));
    }
}

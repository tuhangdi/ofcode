package ali;

/**
 * Created by thd on 2017/8/25
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main1 {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int findCircleNum(int[][] M) {//uniton-find
        int[] id = new int[M.length];
        int count = M.length;
        for (int i = 0; i < M.length; i++) {
            id[i] = i;
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 1) {   //union
                    int pRoot = find(id, i);
                    int qRoot = find(id, j);
                    if (pRoot != qRoot) {
                        id[pRoot] = qRoot;
                        count--;
                    }
                }
            }
        }
        return count;
    }

    private static int find(int[] id, int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _M_rows = 0;
        int _M_cols = 0;
        _M_rows = Integer.parseInt(in.nextLine().trim());
        _M_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _M = new int[_M_rows][_M_cols];
        for(int _M_i=0; _M_i<_M_rows; _M_i++) {
            String row_x=String.valueOf(in.nextLine().trim());
            String[] row_y=row_x.split(",");
            for(int _M_j=0; _M_j<_M_cols; _M_j++) {
                _M[_M_i][_M_j] = Integer.parseInt(row_y[_M_j]);

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = findCircleNum(_M);
        System.out.println(String.valueOf(res));

    }
}

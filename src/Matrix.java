import java.util.ArrayList;

/**
 * Created by thd on 2017/3/3.
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Matrix {
     ArrayList<Integer> printlist = new ArrayList<Integer>();
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int start = 0;
        if (matrix == null) return printlist;
        if (columns == 0){
            for(int i = 0; i < rows; i++) printlist.add(matrix[0][i]);
        }
        if (rows == 0){
            for(int i = 0; i < columns; i++) printlist.add(matrix[columns][0]);
        }

        while(matrix.length > start * 2 && matrix[0].length > start * 2){
            PrintCicle(matrix, columns, rows, start);
            ++start;
        }
        return printlist;
    }
    public void PrintCicle(int [][] matrix, int columns, int rows, int start){
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;
        //从左到右
        for(int i = start; i <= endX; ++i)
            printlist.add(matrix[start][i]);
        //从上到下
        if(start < endY) {
            for (int i = start + 1; i <= endY; ++i)
                printlist.add(matrix[i][endX]);
        }
        //从右到左
        if(start < endX && start < endY){
            for(int i = endX - 1; i >= start; --i)
                printlist.add(matrix[endY][i]);
        }
        //从下到上
        if(start < endX && start < endY - 1){
            for(int i = endY - 1;i >= start + 1; --i)
                printlist.add(matrix[i][start]);
        }
    }
    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        Matrix m = new Matrix();
        ArrayList<Integer> list = m.printMatrix(matrix);
        for(int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}

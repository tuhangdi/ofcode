package offer2;

/**
 * Created by thd on 2017/5/24.
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Sol3 {
    public boolean Find(int target, int[][] array) {
        int m = 0;
        int n = array[0].length - 1;
        boolean find = false;
        while (m < array.length && n >= 0) {
            if (target > array[m][n]) {
                m++;
            } else if (target < array[m][n]) {
                n--;
            } else {
                find = true;
                break;
            }
        }
        return find;
    }

    public static void main(String[] args) {
        int [][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        Sol3 s = new Sol3();
        System.out.println(s.Find(19,array));
    }
}

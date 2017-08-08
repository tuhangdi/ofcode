package jianzhioffer;

/**
 * Created by thd on 2017/2/24.
 */
public class Rotatearray8 {
    public int minNumberInRotateArray(int [] array) {
        int indexlo = 0;
        int indexhi = array.length - 1;
        int indexmin = array[0];
        while (array[indexlo] >= array[indexhi]){
            if((indexhi - indexlo) == 1) {
                indexmin = array[indexhi];
                break;
            }
            indexmin = (indexlo + indexhi) / 2;
            if(array[indexmin] == array[indexlo] && array[indexlo] == array[indexhi]){
                int result = array[0];
                for(int i = 0 ; i < array.length; i++){
                    if(array[i] < result) result = array[i];
                }
                indexmin = result;
                break;
            }
            if(array[indexmin] >= array[indexlo]) indexlo = indexmin;
            else if (array[indexmin] <= array[indexhi]) indexhi = indexmin;
        }
        return indexmin;
    }
    public static void main(String[] args){
        int[] array1 = {7,8,9,1,2,3};
        int[] array2 = {1,1,1,0,1};
        int[] array3 = {1,0,1,1,1};
        int[] array4 = {7,8,9,1,2};
        Rotatearray8 rt = new Rotatearray8();
        System.out.println(rt.minNumberInRotateArray(array1));
        System.out.println(rt.minNumberInRotateArray(array2));
        System.out.println(rt.minNumberInRotateArray(array3));
        System.out.println(rt.minNumberInRotateArray(array4));
    }
}

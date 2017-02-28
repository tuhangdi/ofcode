/**
 * Created by thd on 2017/2/28.
 */
public class Reorder {
    public void reOrderArray(int [] array) {
        int arraylength = array.length;
        int j = 0;
        int[] temp = new int[arraylength];
        for(int i = 0; i < arraylength; i++){
            if((array[i] & 1) == 1) {
                temp[j] = array[i];
                j++;
            }
        }
        for(int i = 0; i < arraylength; i++){
            if((array[i] & 1) == 0){
                temp[j] = array[i];
                j++;
            }
        }
        for (int i = 0; i < arraylength; i++){
            array[i] = temp[i];
            //System.out.println(array[i]);
        }
    }
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7};
        Reorder ro = new Reorder();
        ro.reOrderArray(array);
    }
}

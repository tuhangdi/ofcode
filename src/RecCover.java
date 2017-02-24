/**
 * Created by thd on 2017/2/24.
 */
public class RecCover {
    public int RectCover(int target) {
        if(target == 1) return 1;
        if(target == 0) return 0;
        int f1 = 0;
        int f2 = 1;
        int sum = 0;
        for(int i = 0; i < target; i++) {
            sum =f1 + f2;
            f1 = f2;
            f2 = sum;
        }
        return sum;
    }
}

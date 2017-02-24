/**
 * Created by thd on 2017/2/24.
 */
public class Jump2 {
    public int JumpFloorII(int target) {
        int[] floor = new int[target+1];
        if(target == 0 || target == 1) return target;
        floor[0] = 1;
        floor[1] = 1;
        for(int i = 2; i <= target; i++){
            floor[i] = 0;
            for(int j = 0; j<i; j++){
                floor[i] += floor[j];
            }
        }
        return floor[target];
    }
}

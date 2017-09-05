package ali;

/**
 * Created by thd on 2017/8/25
 */
import java.util.*;

public class Main2 {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int leastBricks(List < List < Integer >> wall) {
        if (wall == null) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (List<Integer> list : wall) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);
                if (map.containsKey(sum))
                    map.put(sum, map.get(sum) + 1);
                else
                    map.put(sum, 1);
                count = Math.max(map.get(sum), count);
            }
        }
        return wall.size() - count;
    }

    public static void main(String[] args){
        List<List<Integer>> vecvecRes = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        int res=-1;

        int row = 0;


        row = Integer.parseInt(in.nextLine().trim());
        int i=0;
        while(i<row){

            int a =Integer.parseInt(in.nextLine().trim());
            if(a==0){
                vecvecRes.add(list);
                list=new ArrayList<Integer>();
                i++;
            }else{
                list.add(a);
            }

        }
        res= leastBricks(vecvecRes);

        System.out.print(res);

    }
}

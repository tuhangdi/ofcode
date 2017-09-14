package hkvision914;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by thd on 2017/9/14
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine())
        {
            String s = sc.nextLine();
            String[] ss = s.split(";");
            if (ss.length <= 2){
                System.out.println("incorrect data");
                continue;
            }
            Map<Integer, ArrayList<String>> map = new HashMap<>();
            for (String t : ss) {
                String[] te = t.split(",");
                if (!map.containsKey(te[0])){
                    map.put(Integer.valueOf(te[0]), new ArrayList<String>());
                }

            }
        }
    }
}

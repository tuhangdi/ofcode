package hw0706;

import java.util.*;

/**
 * Created by thd on 2017/7/6.
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, ArrayList<String>> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String f = sc.next();
            String s = sc.next();
            if (m.containsKey(f)){
                m.get(f).add(s);
            }
            else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(s);
                m.put(f, temp);
            }
        }
        String a = sc.next();
        String b = sc.next();
        isFind = false;
        s.clear();
        dfs(a, b, m);
        boolean aToB = isFind;
        isFind = false;
        s.clear();
        dfs(b, a, m);
        boolean bToA = isFind;
        if (aToB && bToA)
            System.out.println("T");
        else
            System.out.println("F");

    }
    static Set<String> s = new HashSet<>();
    static boolean isFind = false;
    private static void dfs(String a, String b, Map<String, ArrayList<String>> m) {
        if (isFind) return;
        int n = m.get(a).size();
        for (int i = 0; i < n; i++) {
            String fb = m.get(a).get(i);
            if (fb.equals(b)) {
                isFind = true;
                return;
            }
            if (s.contains(fb)) continue;
            s.add(fb);
            dfs(m.get(a).get(i), b, m);
        }
    }

}

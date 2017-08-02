package pdd801;
import java.util.*;
/**
 * Created by thd on 2017/8/1
 */
public class Main44 {
    private static char[][] map;
    private static int m, n, sx, sy, ex, ey;
    private static int[][] next = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static class Step {
        int x;
        int y;
        int cnt;
        Set<Character> keys;

        public Step(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            keys = new HashSet<>();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tm = in.nextInt();
        int tn = in.nextInt();
        in.nextLine();
        m = tm;
        n = tn;
        map = new char[m][n];
        String t;
        for (int i = 0; i < m; i++) {
            t = in.nextLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = t.charAt(j);
                if (map[i][j] == '2') {
                    sx = i;
                    sy = j;
                }
                if (map[i][j] == '3') {
                    ex = i;
                    ey = j;
                }
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        Step start = new Step(sx, sy, 0);
        Queue<Step> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Step cur = queue.poll();
            if (cur.x == ex && cur.y == ey) return cur.cnt;
            for (int i = 0; i < 4; i++) {
                int tx = cur.x + next[i][0];
                int ty = cur.y + next[i][1];
                if (tx >= 0 && tx < m && ty >= 0 && ty < n && map[tx][ty] != '0') {
                    if(map[tx][ty]<'A'||map[tx][ty]>'Z') {
                        Step n = new Step(tx, ty, cur.cnt+1);
                        Set<Character> keys = new HashSet<>(cur.keys);
                        if(map[tx][ty]>='a'&&map[tx][ty]<='z') keys.add(Character.toUpperCase(map[tx][ty]));
                        n.keys = keys;
                        queue.add(n);
                    }else {
                        if(cur.keys.contains(map[tx][ty])) {
                            Step n = new Step(tx, ty, cur.cnt+1);
                            Set<Character> keys = new HashSet<>(cur.keys);
                            n.keys = keys;
                            queue.add(n);
                        }
                    }
                }
            }
        }
        return 0;
    }
}

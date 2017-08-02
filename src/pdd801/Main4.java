package pdd801;

import java.util.*;

/**
 * Created by thd on 2017/8/1
 */
public class Main4 {
    private static char[][] map;
    private static int[][][] use;
    private static int m, n, sx, sy, ex, ey;
    private static int[][] next = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static class Step {
        int x;
        int y;
        int k;


        public Step(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
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
        use = new int[m][n][1024];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 1024; k++) {
                    use[i][j][k] = 0xff;
                }

            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {

        Step start = new Step(sx, sy, 0);
        Queue<Step> queue = new LinkedList<>();
        use[start.x][start.y][start.k] = 0;
        queue.add(start);
        while (!queue.isEmpty()) {
            Step cur = queue.poll();
            if (cur.x == ex && cur.y == ey) return use[cur.x][cur.y][cur.k];
            for (int i = 0; i < 4; i++) {
                Step k = new Step(cur.x + next[i][0], cur.y + next[i][1], cur.k);
                //int tx = cur.x + next[i][0];
                //int ty = cur.y + next[i][1];
                if (k.x < 0 || k.x >= n || k.y < 0 || k.y >= m || map[k.x][k.y] == '0') continue;
                if (map[k.x][k.y] >= 'a' && map[k.x][k.y] <= 'z') {
                    k.k = k.k | (1 << (map[k.x][k.y] - 'a'));
                }
                if (map[k.x][k.y] >= 'A' && map[k.x][k.y] <= 'Z') {
                    int p = k.k & (1 << (map[k.x][k.y] - 'A'));
                    if (p == 0) continue;
                }
                if (use[k.x][k.y][k.k] == -1 || use[k.x][k.y][k.k] > use[cur.x][cur.y][cur.k] + 1) {
                    use[k.x][k.y][k.k] = use[cur.x][cur.y][cur.k] + 1;
                    queue.add(k);
                }
            }
        }
        return -1;
    }
}

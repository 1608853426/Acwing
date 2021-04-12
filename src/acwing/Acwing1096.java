package acwing;

import java.util.Arrays;
import java.util.Scanner;

public class Acwing1096 {
    private static final int N = 110;
    static int l, r, c;
    static int[] dx = new int[]{1, -1, 0, 0, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1, 0, 0};
    static int[] dz = new int[]{0, 0, 0, 0, 1, -1};
    static Point[] list = new Point[(int) Math.pow(N, 3)];
    static char[][][] g = new char[N][N][N];

    static int bfs(Point start, Point end) {
        int[][][] dist = new int[N][N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }
        int hh = 0, tt = 0;
        list[0] = new Point(start);
        dist[start.x][start.y][start.z] = 0;
        while (hh < tt) {
            Point t = new Point(list[hh++]);
            for (int i = 0; i < 6; i++) {
                int x = t.x + dx[i], y = t.y + dy[i], z = t.z + dz[i];
                if (x < 0 || x >= l || y < 0 || y >= r || z < 0 || z >= c) continue;
                ;
                if (g[x][y][z] == '#') continue;
                if (dist[x][y][z] != -1) continue;
                dist[x][y][z] = dist[t.x][t.y][t.z] + 1;
                if (x == end.x && y == end.y && z == end.z) return dist[x][y][z];
                list[++tt] = new Point(x, y, z);
            }
        }
        return -1;
    }

    /*
     * */
    /*
     *
     *　　┏┓　　　┏┓+ +
     *　┏┛┻━━━┛┻┓ + +
     *　┃　　　　　　　┃
     *　┃　　　━　　　┃ ++ + + +
     *  ████━████+
     *  ◥██◤　◥██◤ +
     *　┃　　　┻　　　┃
     *　┃　　　　　　　┃ + +
     *　┗━┓　　　┏━┛
     *　　　┃　　　┃ + + + +Code is far away from
     *　　　┃　　　┃ + bug with the animal protecting
     *　　　┃　 　 ┗━━━┓ 神兽保佑,代码无bug
     *　　　┃ 　　　　　　 ┣┓
     *　　  ┃ 　　　　　 　┏┛
     *　    ┗┓┓┏━┳┓┏┛ + + + +
     *　　　　┃┫┫　┃┫┫
     *　　　　┗┻┛　┗┻┛+ + + +*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            l = in.nextInt();
            r = in.nextInt();
            c = in.nextInt();
            if (l == 0 && r == 0 && c == 0) break;
            Point start = null;
            Point end = null;
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String s = in.next();
                    for (int k = 0; k < c; k++) {
                        g[i][j][k] = s.charAt(k);
                        if (g[i][j][k] == 'S') start = new Point(i, j, k);
                        if (g[i][j][k] == 'E') end = new Point(i, j, k);
                    }
                }

            }
            int distance = bfs(start, end);
            if (distance == -1) System.out.println("Trapped!");
            else System.out.println("Escaped in " + distance + " minute(s).");
        }
    }
}

class Point {
    int x;
    int y;
    int z;

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point(Point obj) {
        this.x = obj.x;
        this.y = obj.y;
        this.z = obj.z;
    }
}
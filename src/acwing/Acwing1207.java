package acwing;

import java.util.ArrayList;
import java.util.Scanner;

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
 *　　　　┗┻┛　┗┻┛+ + + +
 * */
public class Acwing1207 {
    static ArrayList<Integer[]>[] h = new ArrayList[100010];
    static int n;
    static Scanner in = new Scanner(System.in);
    static boolean[] st = new boolean[100010];
    static long[] dist = new long[100010];

    public static void main(String[] args) {
        n = in.nextInt();
        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
            if (!st[a]) {
                st[a] = true;
                h[a] = new ArrayList<>();
            }
            if (!st[b]) {
                st[b] = true;
                h[b] = new ArrayList<>();
            }
            h[a].add(new Integer[]{b, c});
            h[b].add(new Integer[]{a, c});
        }
        dfs(1, -1, 0);
        int u = 1;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > dist[u]) u = i;
        }
        dfs(u, -1, 0);
        for (int i = 1; i <= n; i++) {
            if (dist[i] > dist[u])
                u = i;
        }
        long s = dist[u];
        System.out.println(s * 10 + s * (s + 1) / 2);

    }

    private static void dfs(int u, int father, int distance) {
        dist[u] = distance;
        for (Integer[] node : h[u]) {
            if (node[0] != father) {
                dfs(node[0], u, distance + node[1]);
            }
        }
    }
}

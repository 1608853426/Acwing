package acwing;

import java.io.*;

public class Acwing93 {
    static final int N = 30;
    static int n, m;
    static int[] way = new int[N];
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void dfs(int u, int start) throws IOException {
        if (u + n - start < m) return; // 剪枝
        if (u > m) { // 边界
            for (int i = 1; i <= m; i++)
                out.write(way[i] + " ");
            out.write("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            way[u] = i;
            dfs(u + 1, i + 1); // 下一个数要比前一个数大
        }
    }

    public static void main(String[] args) throws IOException {
        String[] init = in.readLine().split(" ");
        n = Integer.parseInt(init[0]);
        m = Integer.parseInt(init[1]);

        dfs(1, 1);

        in.close();
        out.flush();
        out.close();
    }
}



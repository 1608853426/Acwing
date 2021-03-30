package acwing;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class AcWing_1532 {
    private static final int N = 15;
    static int n;
    static boolean[] col = new boolean[N];
    static boolean[] dg = new boolean[N * 2];
    static boolean[] udg = new boolean[N * 2];
    static int[] path = new int[N];
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        n = Integer.parseInt(str);
        dfs(1);
        System.out.println(ans);
    }

    private static void dfs(int x) {
        if (x > n) {
            ans++;
            if (ans <= 3) {
                for (int i = 1; i <= n; i++) {
                    System.out.print(path[i] + " ");
                }
                System.out.println();
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!col[i] && !dg[x + i] && !udg[x - i + n]) {
                path[x] = i;
                col[i] = dg[x + i] = udg[x - i + n] = true;
                dfs(x + 1);
                col[i] = dg[x + i] = udg[x - i + n] = false;
                path[x] = 0;
            }
        }
    }
}

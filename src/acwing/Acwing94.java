package acwing;


import java.io.*;

public class Acwing94 {
    static int n;
    static boolean[] st = new boolean[15];
    static int[] a = new int[15];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        if (n == 1) {
            System.out.println(1);
            System.exit(0);
        }
        dfs(1);
    }

    private static void dfs(int h) {
        if (h > n) {
            for (int i = 1; i <= n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!st[i]) {
                a[h] = i;
                st[i] = true;
                dfs(h + 1);
                //恢复现场
                a[h] = 0;
                st[i] = false;
            }
        }
    }
}

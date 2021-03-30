package acwing;

import java.io.*;

public class Acwing2 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int[] a = new int[1010];
    static int[] w = new int[1010];
    static int[] f = new int[1010];

    public static void main(String[] args) throws IOException {
        String[] s1 = reader.readLine().split(" ");
        int n = Integer.parseInt(s1[0]), v = Integer.parseInt(s1[1]);
        for (int i = 1; i <= n; i++) {
            String[] s2 = reader.readLine().split(" ");
            a[i] = Integer.parseInt(s2[0]);
            w[i] = Integer.parseInt(s2[1]);
            for (int j = v; j >= a[i]; j--)
                f[j] = Math.max(f[j], f[j - a[i]] + w[i]);
        }
        System.out.println(f[v]);
    }

}

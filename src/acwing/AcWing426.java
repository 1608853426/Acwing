package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcWing426 {
    static int[] f = new int[30010];
    static int n, m, v, w;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        m = Integer.parseInt(str[0]);
        n = Integer.parseInt(str[1]);
        while (n-- != 0) {
            String[] str1 = reader.readLine().split(" ");
            v = Integer.parseInt(str1[0]);
            w = Integer.parseInt(str1[1]);
            w *= v;
            for (int i = m; i >= v; i--) {
                f[i] = Math.max(f[i], f[i - v] + w);
            }
        }
        System.out.println(f[m]);
    }
}

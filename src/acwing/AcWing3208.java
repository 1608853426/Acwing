package acwing;

import java.io.*;

public class AcWing3208 {
    private static final int N = 510;
    private static int[][] a = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= n; i++) {
            String[] str = reader.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                a[i][j] = Integer.parseInt(str[j - 1]);
            }
        }
        for (int i = 2; i <= n * 2; i++) {
            if (i % 2 != 0) {
                for (int j = 1; j < i; j++) {
                    if (j > 0 && j <= n && i - j > 0 && i - j <= n)
                        System.out.print(a[j][i - j] + " ");
                }
            } else {
                for (int j = i - 1; j >= 0; j--) {
                    if (j > 0 && j <= n && i - j > 0 && i - j <= n)
                        System.out.print(a[j][i - j] + " ");
                }
            }
        }
    }
}

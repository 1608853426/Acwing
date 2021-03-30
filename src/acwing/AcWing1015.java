package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcWing1015 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        while (n-- != 0) {
            String[] str = reader.readLine().split(" ");
            int col = Integer.parseInt(str[0]);
            int row = Integer.parseInt(str[1]);
            int[][] a = new int[col + 1][row + 1];
            for (int i = 1; i <= col; i++) {
                String[] str1 = reader.readLine().split(" ");
                for (int j = 1; j <= row; j++) {
                    a[i][j] = Integer.parseInt(str1[j - 1]);
                }
            }
            cal(a, col, row);
        }
        System.exit(0);
    }

    private static void cal(int[][] a, int col, int row) {
        int[][] g = new int[col + 1][row + 1];
        for (int i = 1; i <= col; i++) {
            for (int j = 1; j <= row; j++) {
                g[i][j] = Math.max(g[i][j - 1], g[i - 1][j]) + a[i][j];
            }
        }
        System.out.println(g[col][row]);
    }
}

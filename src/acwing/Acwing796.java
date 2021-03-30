package acwing;

import java.io.*;

public class Acwing796 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]), q = Integer.parseInt(str[2]);
        int[][] map = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String[] s1 = reader.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                map[i][j] = map[i][j - 1] + Integer.parseInt(s1[j - 1]) + map[i - 1][j] - map[i - 1][j - 1];
            }
        }
        while (q-- != 0) {
            String[] s2 = reader.readLine().split(" ");
            int x1 = Integer.parseInt(s2[0]), y1 = Integer.parseInt(s2[1]);
            int x2 = Integer.parseInt(s2[2]), y2 = Integer.parseInt(s2[3]);
            int ans = map[x2][y2] - map[x1 - 1][y2] - map[x2][y1 - 1] + map[x1 - 1][y1 - 1];
            writer.write(ans + "\n");
        }
        writer.flush();
    }
}

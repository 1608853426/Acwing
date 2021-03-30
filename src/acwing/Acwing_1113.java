package acwing;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acwing_1113 {
    private static final int N = 25;
    static char g[][] = new char[N][N];
    static int dx[] = new int[]{-1, 0, 1, 0};
    static int dy[] = new int[]{0, 1, 0, -1};
    static int col, row;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s1[];
            s1 = reader.readLine().split(" ");
            col = Integer.parseInt(s1[0]);
            row = Integer.parseInt(s1[1]);
            if (col == 0 && row == 0) break;
            int x = 0, y = 0;
            for (int i = 0; i < row; i++) {
                String s2 = reader.readLine();
                for (int j = 0; j < col; j++) {
                    g[i][j] = s2.charAt(j);
                    if (g[i][j] == '@') {
                        x = i;
                        y = j;
                    }
                }
            }
            System.out.println(dfs(x, y));
        }
    }

    static int dfs(int sx, int sy) {
        g[sx][sy] = '#';
        int res = 0;
        res++;
        for (int i = 0; i < 4; i++) {
            int x = sx + dx[i], y = sy + dy[i];
            if (x < 0 || x >= row || y < 0 || y >= col || g[x][y] != '.') continue;
            g[x][y] = '#';
            res += dfs(x, y);
        }

        return res;
    }
}

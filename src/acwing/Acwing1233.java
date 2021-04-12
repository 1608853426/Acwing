package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acwing1233 {
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
    static char[][] map = new char[1010][1010];
    static int n;
    static boolean[][] st = new boolean[1010][1010];
    static boolean flag;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= n; i++) {
            String str = reader.readLine();
            for (int j = 1; j <= n; j++) {
                map[i][j] = str.charAt(j - 1);
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                flag = false;
                if (map[i][j] == '#' && !st[i][j]) {
                    dfs(i, j);
                    if (!flag) ans++;
                }
            }
        }
        System.out.println(ans);
    }

    private static void dfs(int i, int j) {
        st[i][j] = true;//标记走过
        if (map[i + 1][j] == '#' && map[i - 1][j] == '#' && map[i][j + 1] == '#' && map[i][j - 1] == '#')
            flag = true;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (!st[x][y] && map[x][y] == '#')
                dfs(x, y);
        }
    }
}

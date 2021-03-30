package acwing;

import java.io.*;

/*
 * 递归枚举第一行的操作，想看数字op的二进制数字第k位是否为1--(op >>k & 1)
 * 记录偏移量--类似dfs/bfs
 *
 * */
public class Acwing95 {
    static int[] dx = {0, 1, 0, -1, 0};
    static int[] dy = {1, 0, -1, 0, 0};
    static int[][] g = new int[5][5];
    static int[][] backup = new int[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {

            //读入一个地图
            for (int i = 0; i < 5; i++) {
                String str = reader.readLine();
                while (str.equals(""))
                    str = reader.readLine();
                for (int j = 0; j < 5; j++)
                    g[i][j] = (int) (str.charAt(j) - '0');
            }

            int res = 10;
            for (int op = 0; op < 32; op++) {
                for (int i = 0; i < 5; i++) {
                    System.arraycopy(g[i], 0, backup[i], 0, 5);
                }

                int step = 0;//记录走了多少步
                for (int i = 0; i < 5; i++) {
                    if ((op >> i & 1) == 1) {
                        step++;
                        turn(0, i);
                    }
                }

                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (backup[i][j] == 0) {
                            turn(i + 1, j);
                            step++;
                        }
                    }
                }

                boolean dark = false;
                for (int i = 0; i < 5; i++) {
                    if (backup[4][i] == 0) {
                        dark = true;
                        break;
                    }
                }
                if (!dark) res = Math.min(res, step);
            }
            if (res > 6) res = -1;
            System.out.println(res);
        }
    }

    private static void turn(int x, int y) {
        for (int i = 0; i < 5; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if (a > -1 && a < 5 && b > -1 && b < 5) {
                backup[a][b] ^= 1;
            }
        }
    }
}

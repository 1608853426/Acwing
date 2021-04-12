package acwing;

import java.util.Scanner;

public class Acwing1212 {
    private static final int N = 55;
    private static final int M = 12;
    private static final int MOD = 1000000007;
    static int[][] map = new int[N][N];
    static int[][][][] dp = new int[N][N][M][M];
    static Scanner in = new Scanner(System.in);
    static int k;

    public static void main(String[] args) {
        int n = in.nextInt(), m = in.nextInt();
        k = in.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                map[i][j] = in.nextInt() + 1;
            }
        }
        //两个边界初始化
        //起点在(1,1)
        //是否拿map[i][j]
        //
        dp[1][1][1][map[1][1]] = 1;
        dp[1][1][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int l = 0; l <= k; l++) {
                    for (int o = 0; o <= 13; o++) {
                        //不取
                        dp[i][j][l][o] = (dp[i][j][l][o] + dp[i - 1][j][l][o]) % MOD;
                        dp[i][j][l][o] = (dp[i][j][l][o] + dp[i][j - 1][l][o]) % MOD;

                        //取
                        if (l > 0 && o == map[i][j]) {
                            for (int p = 0; p < map[i][j]; p++) {
                                dp[i][j][l][o] = (dp[i][j][l][o] + dp[i - 1][j][l - 1][p]) % MOD;
                                dp[i][j][l][o] = (dp[i][j][l][o] + dp[i][j - 1][l - 1][p]) % MOD;
                            }
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < M; i++) {
            res += dp[n][m][k][i];
            res %= MOD;
        }
        System.out.println(res);
    }
}

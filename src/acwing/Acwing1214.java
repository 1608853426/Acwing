package acwing;

import java.util.Scanner;

import static java.lang.Math.*;

public class Acwing1214 {
    private static final int N = 1010;
    private static final int MOD = 100000007;
    static int[][] dp = new int[N][N];
    static Scanner in = new Scanner(System.in);

    static int n, s, a, b;

    public static void main(String[] args) {
        n = in.nextInt();
        s = in.nextInt();
        a = in.nextInt();
        b = in.nextInt();
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = (dp[i - 1][floorMod(j - a * i, n)] + dp[i - 1][floorMod(j + b * i, n)]) % MOD;
            }
        }
        System.out.println(dp[n - 1][floorMod(s, n)]);
    }

}

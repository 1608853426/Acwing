package acwing;

import java.util.Scanner;

public class Acwing898 {
    public static void main(String[] args) {
        int a[][] = new int[510][510];
        int dp[][] = new int[510][510];
        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                a[i][j] = input.nextInt();
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i + 1; j++)
                dp[i][j] = Integer.MIN_VALUE;
        }
        dp[1][1] = a[1][1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                dp[i][j] = Math.max(dp[i - 1][j - 1] + a[i][j], dp[i - 1][j] + a[i][j]);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n + 1; i++) {
            ans = Math.max(ans, dp[n][i]);
        }
        System.out.println(ans);
    }
}

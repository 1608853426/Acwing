package acwing;


import java.util.Scanner;

public class Acwing_1371 {
    public static void main(String[] args) {
        //读入输入
        Scanner input = new Scanner(System.in);
        int v = input.nextInt();
        int n = input.nextInt();
        int[] a = new int[v];
        for (int i = 0; i < v; i++) {
            a[i] = input.nextInt();
        }
        input.close();
        //使用 n + 1 大小的数组存储方法数
        //dp[i] 代表 凑够 i 块钱的方法数
        //每多出一个新面额v 则dp[i] 增加 dp[i - v]中方法
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = a[i]; j <= n; j++) {
                dp[j] += dp[j - a[i]];
            }
        }
        System.out.println(dp[n]);
    }
}

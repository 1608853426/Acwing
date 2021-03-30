package acwing;

import java.util.Scanner;

public class AcWing126 {
    static int[][] a = new int[105][105];

    public static void main(String[] args) {
        //输入不规则，BufferedReader.readline()处理起来有点麻烦，用Scanner算了
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = in.nextInt();
                a[i][j] += a[i][j - 1];
            }
        }
        int ans = Integer.MIN_VALUE;
        //枚举左右边界
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int temp = 0;
                for (int k = 1; k <= n; k++) {
                    temp = Math.max(0, temp) + (a[k][j] - a[k][i - 1]);
                    ans = Math.max(ans, temp);
                }
            }
        }
        System.out.println(ans);

    }
}

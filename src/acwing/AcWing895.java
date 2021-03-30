package acwing;

import java.util.Scanner;

public class AcWing895 {
    static int[] a = new int[1010];
    static int[] b = new int[1010];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt(), res = 0;
        a[0] = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    b[i] = Math.max(b[i], b[j] + 1);
                }
                res = Math.max(res, b[i]);
            }
        }
        System.out.println(res);
    }
}

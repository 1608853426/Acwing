package acwing;

import java.util.Scanner;

public class Acwing1205 {
    private static final int N = 1000000;
    static int n, m;
    static boolean[] a = new boolean[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();
        a[n] = true;
        a[m] = true;
        for (int i = 1; i < N; i++) {
            if (i < N - n && a[i]) a[i + n] = true;
            if (i < N - m && a[i]) a[i + m] = true;
        }
        for (int i = N - 1; i > 0; i--) {
            if (!a[i]) {
                System.out.println(i);
                break;
            }
        }
    }
}

package acwing;

import java.util.Arrays;
import java.util.Scanner;

public class Acwing104 {
    static Scanner in = new Scanner(System.in);
    static int[] a = new int[100010];

    public static void main(String[] args) {
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a, 1, n);
        int temp = ((n & 1) == 1) ? n + 1 >> 1 : n >> 1;
        long res = 0;
        for (int i = 1; i <= n; i++) {
            res += Math.abs(a[temp] - a[i]);
        }
        System.out.println(res);
    }
}

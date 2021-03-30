package acwing;


import java.util.Scanner;

public class Acwing795 {

    static Scanner in = new Scanner(System.in);
    static int[] a = new int[100010];

    public static void main(String[] args) {
        int n = in.nextInt(), q = in.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt() + a[i - 1];
        }
        while (q-- != 0) {
            int l = in.nextInt() - 1, r = in.nextInt();
            System.out.println(a[r] - a[l]);
        }

    }
}

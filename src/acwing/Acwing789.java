package acwing;

import java.util.Scanner;

public class Acwing789 {
    static int[] a = new int[100000];
    static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int q = in.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        while (q-- != 0) {
            int s = in.nextInt();
            search(s);
        }
    }

    private static void search(int s) {
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (a[mid] < s) l = mid + 1;
            else r = mid;
        }
        if (a[l] != s) {
            System.out.println(-1 + " " + -1);
        } else if (l == n - 1) {
            System.out.println(l + " " + l);
        } else {
            int x = l;
            while (a[x + 1] == s) x++;
            System.out.println(l + " " + x);
        }
    }
}

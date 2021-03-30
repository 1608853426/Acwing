package acwing;

import java.io.*;
import java.util.Scanner;

public class Acwing1204 {
    private static final int N = 100010;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int[] a = new int[N];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = in.nextInt(), min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int res1 = 0, res2 = 0;
        while (in.hasNext()) {
            int temp = in.nextInt();
            a[temp]++;
            min = Math.min(min, temp);
            max = Math.max(max, temp);
        }

        for (int i = min; i <= max; i++) {
            if (a[i] == 0) res1 = a[i];
            if (a[i] > 1) res2 = a[i];
        }
        System.out.println(res1 + " " + res2);
    }
}

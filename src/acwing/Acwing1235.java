package acwing;

import java.util.Arrays;
import java.util.Scanner;

public class Acwing1235 {
    static Scanner in = new Scanner(System.in);
    static int[] a = new int[500010];

    public static void main(String[] args) {
        double n = in.nextDouble(), s = in.nextDouble();
        double arg = (double) (s / n);
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        double res = 0;
        Arrays.sort(a, 0, (int) (n + 1));
        for (int i = 1; i <= n; i++) {
            if (a[i] >= s / (n - i + 1)) {
                double temp = Math.abs(s / (n - i + 1) - arg);
                res += (n - i + 1) * Math.pow(temp, 2);
                break;
            } else {
                double temp = Math.abs(a[i] - arg);
                res += Math.pow(temp, 2);
                s -= a[i];
            }
        }
        System.out.printf("%.4f", Math.sqrt(res / n));
    }
}

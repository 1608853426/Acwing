package acwing;

import java.util.*;

public class AcWing458 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), b = in.nextInt(), l = in.nextInt(), a1 = 0, a2 = 0;
        double exp = 1e9;
        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= l; j++) {
                int x = b * i, y = a * j;
                if (gcd(i, j) == 1 && x >= y && x - y < exp) {
                    exp = x - y;
                    a1 = i;
                    a2 = j;
                }
            }
            System.out.println(a1 + " " + a2);
        }
    }

    private static int gcd(int i, int j) {
        if (j == 0) return i;
        else return gcd(j, i % j);
    }
}

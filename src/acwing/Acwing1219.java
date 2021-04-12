package acwing;

import java.util.Scanner;

import static java.lang.Math.abs;


public class Acwing1219 {
    static int w, m, n;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        w = in.nextInt();
        m = in.nextInt();
        n = in.nextInt();
        m--;
        n--;
        int y1 = m / w;
        int y2 = n / w;
        int x1 = cal(m);
        int x2 = cal(n);
        System.out.println(abs(x1 - x2) + abs(y1 - y2));
    }

    private static int cal(int x) {
        if ((x / w & 1) == 1) {
            return w - (x % w) - 1;
        }
        return x % w;
    }
}

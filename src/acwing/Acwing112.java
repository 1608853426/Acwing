package acwing;

import java.util.Arrays;
import java.util.Scanner;

public class Acwing112 {
    private static final int N = 1010;
    static int n, r;
    static Scanner in = new Scanner(System.in);
    static Segment[] seg = new Segment[N];

    public static void main(String[] args) {
        n = in.nextInt();
        r = in.nextInt();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            if (y > r) {
                System.out.println(-1);
                System.exit(0);
            }
            double len = Math.sqrt(r * r - y * y);
            seg[i] = new Segment(x - len, x + len);
        }
        Arrays.sort(seg, 0, n);
        int cnt = 0;
        double last = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (last < seg[i].l) {
                cnt++;
                last = seg[i].r;
            }
        }
        System.out.println(cnt);
    }
}

class Segment implements Comparable<Segment> {
    double l;
    double r;

    public Segment(double l, double r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public int compareTo(Segment o) {
        return Double.compare(r, o.r);
    }
}
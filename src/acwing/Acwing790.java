package acwing;

import java.io.*;

public class Acwing790 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        double n = Double.parseDouble(reader.readLine());
        double l = 0, r = n;
        double eps = 1e-8;
        while (r - l > eps) {
            double mid = (l + r) / 2;
            if (Math.pow(mid, 3) > n)
                r = mid;
            else l = mid;
        }
        System.out.printf("%.6f", l);
    }
}

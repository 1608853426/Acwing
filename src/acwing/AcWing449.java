package acwing;

import java.util.Scanner;

import static java.lang.Math.*;

public class AcWing449 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double n = in.nextDouble();
        for (int i = 2; i < n; i++) {
            double temp = n / i;
            if (temp % 1 < 1e-6) {
                System.out.println(max((int) temp, i));
                break;
            }
        }
        System.exit(0);
    }
}

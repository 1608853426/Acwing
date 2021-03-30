package acwing;

import java.util.Scanner;

public class AcWing3232 {
    static int a, b, ans;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        b = in.nextInt();
        while (in.hasNext()) {
            a = in.nextInt();
            ans = Math.max(ans, Math.abs(a - b));
            b = a;
        }
        System.out.println(ans);
    }
}

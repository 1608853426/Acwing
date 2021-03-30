package acwing;

import java.util.Scanner;

public class Acwing1216 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        int res = n;
        while (n > 2) {
            int rest = n % 3;
            int add = n / 3;
            res += add;
            n = rest + add;
        }
        System.out.println(res);
    }
}

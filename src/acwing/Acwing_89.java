package acwing;

import java.util.Scanner;

public class Acwing_89 {
    public static void main(String[] args) {
        //快速幂(反复平方法)
        //先拆成二进制
        long a, b, p;
        Scanner in = new Scanner(System.in);
        a = in.nextInt();
        b = in.nextInt();
        p = in.nextInt();
        System.out.println(qmi(a, b, p));
        System.exit(0);
    }

    private static long qmi(long a, long b, long p) {
        long res = 1;
        while (b != 0) {
            if ((b & 1) == 1) res = res * a % p;
            a %= p;
            a *= a;
            a %= p;
            //a =  a * a % p;
            b >>= 1;
        }
        return res;
    }
}

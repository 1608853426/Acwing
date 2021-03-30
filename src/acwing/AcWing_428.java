package acwing;

import java.util.Scanner;

public class AcWing_428 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();
        long res = 0;
        String s = Integer.toBinaryString(n);
        for (int i = 0; i < s.length(); i++) {
            int temp = 1;
            for (int j = 1; j <= i; j++) {
                temp *= k;
            }
            if ((s.charAt(s.length() - i - 1) - '0') == 1) res += temp;
        }
        System.out.println(res);
    }
}


package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcWing754 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = reader.readLine();
            int n = Integer.parseInt(str);
            if (n == 0) return;
            out(n);
        }
    }

    private static void out(int n) {
        int a[][] = new int[n][n];
        //abs(i - j) = 0~n-1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = Math.abs(i - j) + 1;
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcWing_1381 {
    static int ans = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = n; i > 0; i--) {
            ans *= i;
            while (ans % 10 == 0) ans /= 10;
            ans %= 1e6;
        }
        while (ans > 9) ans %= 10;
        System.out.println(ans);

    }
}

package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Acwing1240 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] arr = new int[100010];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(reader.readLine().trim());
        String[] buffer;
        buffer = reader.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(buffer[i - 1]);
        }
        long max = Integer.MIN_VALUE;
        int res = 0;
        for (int i = 1, d = 1; i <= n; i <<= 1, d++) {
            long temp = 0;
            for (int j = i; j < Math.min(n + 1, i * 2); j++) {
                if (j < 100009)
                    temp += arr[j];
            }
            if (temp > max) {
                max = Math.max(temp, max);
                res = d;
            }
        }
        System.out.println(res);
    }


}

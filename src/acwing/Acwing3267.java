package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acwing3267 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int[] st = new int[4];

    public static void main(String[] args) throws IOException {
        String[] s = reader.readLine().split(" ");
        for (int i = 0; i < 3; i++) {
            st[i + 1] = Integer.parseInt(s[i]);
        }
        int n = Integer.parseInt(reader.readLine()), res = 0;
        while (n-- != 0) {
            String[] str = reader.readLine().split(" ");
            switch (Integer.parseInt(str[0])) {
                case 0:
                    res += Integer.parseInt(str[1]);
                case 1:
                    res += Integer.parseInt(str[1]);
                case 2:
                    res += (Integer.parseInt(str[1]) + st[1]);
                default:
                    break;
            }

        }
        System.out.println(res);
    }
}

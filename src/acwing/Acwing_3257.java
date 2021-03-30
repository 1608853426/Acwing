package acwing;

import java.io.*;

public class Acwing_3257 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int res = Integer.parseInt(str[0]);
        if (str.length <= 2) {
            System.out.println(res);
            System.exit(0);
        }
        for (int i = 1; i < str.length; i++) {
            if (Integer.parseInt(str[i]) == 2 && Integer.parseInt(str[i - 1]) > 1)
                str[i] = String.valueOf(2 + Integer.parseInt(str[i - 1]));
            res += Integer.parseInt(str[i]);
        }
        System.out.println(res);
    }
}

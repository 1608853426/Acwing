package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Acwing1346 {
    static int b;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        b = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= 300; i++) {
            String num = base(i * i, b);
            if (check(num)) {
                System.out.println(base(i, b) + " " + num);
            }
        }
        return;
    }

    private static boolean check(String num) {
        for (int i = 0, j = num.length() - 1; i < j; i++, j--) {
            if (num.charAt(i) != num.charAt(j)) return false;
        }
        return true;
    }

    private static String base(int i, int b) {
        String num = "";
        while (i != 0) {
            num += get(i % b);
            i /= b;
        }

        return reverse(num);
    }

    private static String reverse(String num) {
        String mun = "";
        for (int i = num.length() - 1; i >= 0; i--) {
            mun += num.charAt(i);
        }
        return mun;
    }

    private static char get(int i) {
        if (i < 10) {
            return (char) (i + '0');
        } else {
            return (char) (i - 10 + 'A');
        }
    }
}

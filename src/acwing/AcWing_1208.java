package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcWing_1208 {

    static String str1;
    static String str2;
    static StringBuilder builder1;
    static StringBuilder builder2;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        str1 = reader.readLine();
        str2 = reader.readLine();
        builder1 = new StringBuilder(str1);
        builder2 = new StringBuilder(str2);
        int res = 0;
        for (int i = 0; i < builder1.length() - 1; i++) {
            if (builder1.charAt(i) != builder2.charAt(i)) {
                res++;
                turn(i);
                turn(i + 1);
            }
        }
        System.out.println(res);

    }

    private static void turn(int i) {
        if (builder1.charAt(i) == '*') {
            builder1.setCharAt(i, 'o');
        } else if (builder1.charAt(i) == 'o') {
            builder1.setCharAt(i, '*');
        }
    }
}

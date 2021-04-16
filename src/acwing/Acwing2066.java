package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acwing2066 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String s = reader.readLine();
        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < s.length() - 1; i++) {
            if (isLetter(s.charAt(i)) && isNumber(s.charAt(i + 1))) {
                for (int j = 0; j < s.charAt(i + 1) - '0'; j++) {
                    res.append(s.charAt(i));
                }
                i++;
            } else if (isLetter(s.charAt(i)) && !isNumber(s.charAt(i + 1))) {
                res.append(s.charAt(i));
            }
        }
        if (isLetter(s.charAt(s.length() - 1))) res.append(s.charAt(s.length() - 1));
        System.out.println(res);
    }

    private static boolean isNumber(char c) {
        return c >= '1' && c <= '9';
    }

    private static boolean isLetter(char c) {
        return c >= 'A' && c <= 'z';
    }
}

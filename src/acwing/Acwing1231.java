package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acwing1231 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String s1 = reader.readLine();
            String s2 = reader.readLine();
            int time = (get_time(s1) + get_time(s2)) >> 1;
            int hour = time / 3600, minute = time % 3600 / 60, second = time % 60;
            System.out.printf("%02d:%02d:%02d\n", hour, minute, second);
        }
    }

    private static int get_time(String t) {
        if (t.charAt(t.length() - 1) != ')') t += " (+0)";
        String[] t1 = t.split(" ");
        String[] t2 = t1[0].split(":");
        String[] t3 = t1[1].split(":");
        int h1 = Integer.parseInt(t2[0]);
        int m1 = Integer.parseInt(t2[1]);
        int s1 = Integer.parseInt(t2[2]);
        int h2 = Integer.parseInt(t3[0]);
        int m2 = Integer.parseInt(t3[1]);
        int s2 = Integer.parseInt(t3[2]);
        int d = t1[2].charAt(2) - '0';
        return get_second(h2, m2, s2) - get_second(h1, m1, s1) + d * 24 * 3600;
    }

    private static int get_second(int h1, int m1, int s1) {
        return h1 * 3600 + m1 * 60 + s1;
    }
}

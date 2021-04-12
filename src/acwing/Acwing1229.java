package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acwing1229 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int[] date = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int a, b, c;

    public static void main(String[] args) throws IOException {
        String[] str = reader.readLine().split("/");
        a = Integer.parseInt(str[0]);
        b = Integer.parseInt(str[1]);
        c = Integer.parseInt(str[2]);
        for (int i = 19600101; i <= 20591231; i++) {
            int year = i / 10000 % 100;
            int y = i / 10000;
            int month = i / 100 % 100;
            int day = i % 100;
            if (year % 100 == a && month == b && day == c || //年/月/日
                    month == a && day == b && year % 100 == c || //月/日/年
                    day == a && month == b && year % 100 == c) {
                if (check(y, month, day)) {
                    System.out.printf("%d-%02d-%02d\n", y, month, day);
                }
            }
        }

    }

    private static boolean check(int year, int month, int day) {
        if (month < 1 || month > 12) return false;
        if (day < 1 || month != 2 && day > date[month]) return false;
        if (month == 2) {
            int leap = 0;
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                leap++;
            }
            if (day > 28 + leap) return false;
        }
        return true;
    }
}

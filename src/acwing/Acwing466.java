package acwing;

import java.io.*;

public class Acwing466 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int[] map = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        int startDate = Integer.parseInt(reader.readLine());
        int endDate = Integer.parseInt(reader.readLine());
        int res = 0;
        for (int i = 1000; i < 10000; i++) {
            int date = i, temp = i;
            for (int j = 0; j < 4; j++) {
                date = date * 10 + temp % 10;
                temp /= 10;
            }
            if (date >= startDate && date <= endDate && check(date)) res++;
        }
        System.out.println(res);
    }

    static boolean check(int date) {
        int year = date / 10000;
        int month = date % 10000 / 100;
        int day = date % 100;
        if (month == 0 || month > 12) return false;
        if (day == 0 || month != 2 && day > map[month]) return false;

        if (month == 2) {
            int leap = 0;//0表示平年，1表示闰年
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
                leap = 1;
            if (day > 28 + leap) return false;
        }
        return true;
    }
}

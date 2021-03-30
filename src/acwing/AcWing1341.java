package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcWing1341 {
    static int mon[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int weekday[] = new int[7];

    public static void main(String[] args) throws IOException {
        //枚举每月第一天距离1900年1月1号过了多少天
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String strs;
        strs = reader.readLine();
        int n = Integer.parseInt(strs);
        //外层循环年，内层循环月
        int days = 0;
        for (int i = 1900; i < 1900 + n; i++) {
            for (int j = 1; j <= 12; j++) {
                weekday[(days + 12) % 7]++;
                days += mon[j];
                if (j == 2) {
                    if (i % 100 != 0 && i % 4 == 0 || i % 400 == 0)
                        days++;
                }
            }
        }

        for (int i = 5, j = 0; j < 7; i = (i + 1) % 7, j++) {
            System.out.print(weekday[i] + " ");
        }
    }
}

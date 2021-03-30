package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Acwing680 {
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1[] = reader.readLine().split(" ");
        n = Integer.parseInt(str1[0]);
        m = Integer.parseInt(str1[1]);
        String str2[] = reader.readLine().split(" ");
        for (int i = 0; i < str2.length; i++) {
            arrayList.add(Integer.valueOf(str2[i]));
        }
        double l = 0, r = 1e9;
        while (r - l > 1e-4) {
            double mid = (r + l) / 2;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        String ans = String.format("%.2f", l);
        System.out.println(ans);
    }

    private static boolean check(double v) {
        int cnt = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            cnt += arrayList.get(i) / v;
        }
        if (cnt >= m) return true;
        else return false;
    }
}

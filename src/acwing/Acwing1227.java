package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Acwing1227 {
    private static int n, m;
    private static ArrayList<int[]> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1[] = reader.readLine().split(" ");
        n = Integer.parseInt(str1[0]);
        m = Integer.parseInt(str1[1]);
        for (int i = 0; i < n; i++) {
            String str2[] = reader.readLine().split(" ");
            int in[] = new int[]{Integer.parseInt(str2[0]), Integer.parseInt(str2[1])};
            arrayList.add(in);
        }
        int l = 0, r = 100010;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(l);
    }

    private static boolean check(int mid) {
        int cnt = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            int temp[] = arrayList.get(i);
            cnt += (temp[0] / mid) * (temp[1] / mid);
        }
        return cnt >= m;
    }
}

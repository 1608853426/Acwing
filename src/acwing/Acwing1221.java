package acwing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Acwing1221 {
    static ArrayList<int[]> list = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        for (int c = 0; c * c <= n; c++) {
            for (int d = c; d * d + c * c <= n; d++) {
                list.add(new int[]{c * c + d * d, c, d});
            }
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                }
                return o1[2] - o2[2];
            }
        });

        for (int a = 0; a * a <= n; a++) {
            for (int b = a; b * b + a * a <= n; b++) {
                int t = n - a * a - b * b;
                int l = 0, r = list.size() - 1;
                while (l < r) {
                    int mid = l + r >> 1;
                    if (list.get(mid)[0] >= t) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }

                if (list.get(l)[0] == t) {
                    int c = list.get(l)[1], d = list.get(l)[2];
                    System.out.println(a + " " + b + " " + c + " " + d);
                    return;
                }
            }
        }
    }
}

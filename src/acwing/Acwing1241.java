package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Acwing1241 {
    private static final int N = 100010;

    static int[] score = new int[N];
    static int[] last = new int[N];
    static boolean[] st = new boolean[N];


    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] line1 = reader.readLine().split(" ");

        int n = Integer.parseInt(line1[0]), m = Integer.parseInt(line1[1]), k = Integer.parseInt(line1[2]), res = 0;
        PIIs[] list = new PIIs[m];
        for (int i = 0; i < m; i++) {
            String[] s = reader.readLine().split(" ");
            int ts = Integer.parseInt(s[0]), id = Integer.parseInt(s[1]);
            list[i] = new PIIs(ts, id);
        }
        Arrays.sort(list);
        for (int i = 0; i < m; ) {
            int j = i;
            while (j < m && list[j].ts == list[i].ts && list[j].id == list[i].id) j++;
            int ts = list[i].ts, id = list[i].id, cnt = j - i;
            i = j;
            score[id] -= ts - last[id] - 1;
            if (score[id] < 0) score[id] = 0;
            if (score[id] <= 3) st[id] = false;

            score[id] += cnt * 2;
            if (score[id] > 5) st[id] = true;

            last[id] = ts;
        }
        for (int i = 1; i <= n; i++) {
            if (last[i] < k) {
                score[i] -= k - last[i];
                if (score[i] <= 3) st[i] = false;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (st[i]) res++;
        }
        System.out.println(res);
    }
}

class PIIs implements Comparable<PIIs> {
    int ts;
    int id;

    public PIIs(int ts, int id) {
        this.ts = ts;
        this.id = id;
    }

    @Override
    public int compareTo(PIIs o) {
        if (this.ts != o.ts) return Integer.compare(ts, o.ts);
        return Integer.compare(this.id, o.id);
    }
}

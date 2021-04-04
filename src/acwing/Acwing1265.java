package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acwing1265 {
    static int[] tree = new int[32020];
    static int[] level = new int[32020];
    static int n = 0;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(reader.readLine().trim());
        for (int i = 0; i < n; i++) {
            String[] s1 = reader.readLine().split(" ");
            int x = Integer.parseInt(s1[0]) + 1;
            level[sum(x)]++;
            add(x, 1);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(level[i]);
        }

    }

    static int lowbit(int x) {
        return x & -x;
    }

    static void add(int x, int v) {
        for (int i = x; i < 32020; i += lowbit(i)) {
            tree[i] += v;
        }
    }

    static int sum(int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += tree[i];
        }
        return res;
    }
}

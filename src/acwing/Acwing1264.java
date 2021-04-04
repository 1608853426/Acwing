package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acwing1264 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr = new int[100010];
    static int[] tree = new int[100010];
    static int n;
    static int m;


    public static void main(String[] args) throws IOException {
        String[] str1 = reader.readLine().split(" ");
        n = Integer.parseInt(str1[0]);
        m = Integer.parseInt(str1[1]);
        String[] str2 = reader.readLine().split(" ");
        for (int i = 1; i <= str2.length; i++) {
            arr[i] = Integer.parseInt(str2[i - 1]);
        }

        //建立树状数组
        for (int i = 1; i <= n; i++) {
            add(i);
        }
        while (m-- != 0) {
            String[] tmp = reader.readLine().split(" ");
            int k = Integer.parseInt(tmp[0]);
            int x = Integer.parseInt(tmp[1]);
            int y = Integer.parseInt(tmp[2]);
            if (k == 0) {
                int res = query(y) - query(x - 1);
                System.out.println(res);
            } else {
                add(x, y);
            }
        }

    }

    private static int query(int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += tree[i];
        }
        return res;
    }

    private static void add(int x, int y) {
        for (int i = x; i <= n; i += lowbit(i)) {
            tree[i] += y;
        }
    }

    private static void add(int x) {
        for (int i = x; i <= n; i += lowbit(i)) {
            tree[i] += arr[x];
        }
    }

    private static int lowbit(int x) {
        return x & -x;
    }
}

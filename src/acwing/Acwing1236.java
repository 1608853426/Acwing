package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Acwing1236 {
    private static final int N = 100010;
    private static int[] a = new int[N];
    private static int[] b = new int[N];
    private static int[] c = new int[N];
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        String[] s1 = reader.readLine().split(" ");
        String[] s2 = reader.readLine().split(" ");
        String[] s3 = reader.readLine().split(" ");

        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(s1[i - 1]);
            b[i] = Integer.parseInt(s2[i - 1]);
            c[i] = Integer.parseInt(s3[i - 1]);
        }
        Arrays.sort(a, 0, n + 1);
        Arrays.sort(b, 0, n + 1);
        Arrays.sort(c, 0, n + 1);

        long res = 0;
        for (int i = 1; i <= n; i++) {
            //找到a[]数组中最小的大于等于bi的元素位置
            int la = 0, ra = n + 1;
            while (la < ra) {
                int mid = (la + ra) >> 1;
                if (a[mid] >= b[i]) ra = mid;
                else la = mid + 1;
            }
            //找到c[]数组中最大的小于等于bi的元素位置
            int lb = 0, rb = n + 1;
            while (lb < rb) {
                int mid = (lb + rb + 1) >> 1;
                if (c[mid] <= b[i]) lb = mid;
                else rb = mid - 1;
            }
            if (la == 0 || lb == n + 1) continue;
            res += ((long) (la - 1) * (n - lb));
        }
        System.out.println(res);
    }
}


package acwing;

import java.io.*;

public class AcWing_3203 {
    static int[][] a = new int[110][110];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0, n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] d = reader.readLine().split(" ");
            for (int j = Integer.parseInt(d[0]); j < Integer.parseInt(d[2]); j++)
                for (int k = Integer.parseInt(d[1]); k < Integer.parseInt(d[3]); k++)
                    a[j][k]++;
        }
        for (int[] a1 : a)
            for (int a2 : a1)
                if (a2 > 0) ans++;
        System.out.println(ans);
    }
}

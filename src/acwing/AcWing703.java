package acwing;

import java.io.*;
import java.util.HashSet;

public class AcWing703 {
    static int[][] a = new int[40][40];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        int s = 1;
        while (s <= t) {
            int n = Integer.parseInt(reader.readLine());
            int m = n * n;
            for (int i = 1; i <= m; i++) {
                String[] str = reader.readLine().split(" ");
                for (int j = 1; j <= m; j++) {
                    a[i][j] = Integer.parseInt(str[j - 1]);
                }
            }
            if (check_row(a, n) && check_col(a, n) && check_square(a, n)) {
                System.out.println("Case #" + s + ": Yes");
            } else {
                System.out.println("Case #" + s + ": No");
            }
            s++;
        }


    }

    private static boolean check_square(int[][] a, int n) {
        int m = n * n;
        for (int i = 1; i <= m; i += n) {
            for (int j = 1; j <= m; j += n) {
                HashSet<Integer> hashSet = new HashSet<Integer>();
                for (int k = i; k <= i + n; k++) {
                    for (int l = j; l <= j + n; l++) {
                        hashSet.add(a[k][l]);
                    }
                }
                if (hashSet.size() < m) return false;
            }
        }
        return true;
    }

    private static boolean check_col(int[][] a, int n) {
        int m = n * n;
        for (int i = 1; i <= m; i++) {
            HashSet<Integer> hashSet = new HashSet<Integer>();
            for (int j = 1; j <= m; j++) {
                if (a[i][j] < 1 || a[i][j] > m) return false;
                hashSet.add(a[i][j]);
            }
            if (hashSet.size() < m) return false;
        }
        return true;
    }

    private static boolean check_row(int[][] a, int n) {
        int m = n * n;
        for (int i = 1; i <= m; i++) {
            HashSet<Integer> hashSet = new HashSet<Integer>();
            for (int j = 1; j <= m; j++) {
                if (a[i][j] < 1 || a[i][j] > m) return false;
                hashSet.add(a[j][i]);
            }
            if (hashSet.size() < m) return false;
        }
        return true;
    }

}

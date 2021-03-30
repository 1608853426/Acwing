package acwing;


import java.io.*;

public class Acwing1210 {
    static int res = 0;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(reader.readLine());
        String[] str = reader.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
            for (int j = i; j <= n; j++) {
                l = Math.min(l, Integer.parseInt(str[j - 1]));
                r = Math.max(r, Integer.parseInt(str[j - 1]));

                if (j == i) res++;
                else if ((j - i) == (r - l))
                    res++;
            }
        }
        System.out.println(res);
    }
}

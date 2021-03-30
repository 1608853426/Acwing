package acwing;


import java.io.*;

public class AcWing_3227 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        String[] str = reader.readLine().split(" ");
        int res = 0;
        for (int i = 2; i < str.length; i++) {
            int cnt1 = Integer.parseInt(str[i - 1]) - Integer.parseInt(str[i - 2]);
            int cnt2 = Integer.parseInt(str[i]) - Integer.parseInt(str[i - 1]);
            if (cnt1 * cnt2 <= 0) res++;
        }
        System.out.println(res);
    }
}

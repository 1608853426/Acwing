package acwing;

import java.io.*;

public class AcWing_421 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int can = Integer.parseInt(reader.readLine()) + 30;
        int res = 0;
        for (int i = 0; i < str.length; i++) {
            if (can >= Integer.parseInt(str[i])) res++;
        }
        System.out.println(res);
    }
}

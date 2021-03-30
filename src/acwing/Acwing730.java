package acwing;

import java.io.*;

public class Acwing730 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        String[] map = reader.readLine().split(" ");
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            if ((res + Integer.parseInt(map[i]) & 1) == 1)
                res = (res + Integer.parseInt(map[i])) / 2 + 1;
            else
                res = (res + Integer.parseInt(map[i])) / 2;
        }
        writer.write(res + "\n");
        writer.flush();
    }
}

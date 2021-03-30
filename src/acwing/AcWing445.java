package acwing;

import java.io.*;

public class AcWing445 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        StringBuilder ans = new StringBuilder("");
        for (int i = str.length() - 1; i >= 0; i--) {
            ans.append(str.charAt(i));
        }
        while (ans.charAt(0) == '0') ans.deleteCharAt(0);
        if (ans.charAt(ans.length() - 1) == '-') {
            ans.deleteCharAt(ans.length() - 1);
            ans.insert(0, '-');
        }
        System.out.println(ans);
    }
}

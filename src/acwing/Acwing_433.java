package acwing;

import java.io.*;

public class Acwing_433 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str1 = new StringBuilder(reader.readLine());
        //String str1 = reader.readLine();
        StringBuilder str = new StringBuilder(str1);
        str.deleteCharAt(11);
        str.deleteCharAt(5);
        str.deleteCharAt(1);
        long sum = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            sum += ((i + 1) * (str.charAt(i) - '0'));
        }
        sum %= 11;
        char c = 'X';
        if (sum < 10) c = (char) ('0' + sum);
        if (c == str1.charAt(str1.length() - 1)) System.out.println("Right");
        else {
            str1.replace(str1.length() - 1, str1.length() - 1, String.valueOf(c));
            System.out.println(str1);
        }
    }
}

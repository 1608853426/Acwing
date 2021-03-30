package acwing;


import java.util.Scanner;

public class Acwing1245 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt(), res = 0;
        for (int i = 1; i <= n; i++)
            if (String.valueOf(i).contains("2") || String.valueOf(i).contains("0") || String.valueOf(i).contains("1") || String.valueOf(i).contains("9"))
                res += i;
        System.out.println(res);
    }
}

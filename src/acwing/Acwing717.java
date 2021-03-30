package acwing;

import java.util.Scanner;

public class Acwing717 {
    //递归
    static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int a = 0, b = 1, c;
        while (n-- != 0) {
            System.out.print(a + " ");
            c = a + b;
            a = b;
            b = c;
        }
    }


}

package acwing;

import java.util.Scanner;

public class AcWing_417 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = 1; i <= 7; i++) {
            if (in.nextInt() + in.nextInt() > 8) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("0");
    }
}

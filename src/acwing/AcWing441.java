package acwing;


import java.util.*;

public class AcWing441 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt(), r = in.nextInt();
        int ans = 0;
        for (int i = l; i <= r; i++) {
            int j = i;
            while (j >= 2) {
                if (j % 10 == 2) ans++;
                j /= 10;
            }
        }
        System.out.println(ans);
    }
}

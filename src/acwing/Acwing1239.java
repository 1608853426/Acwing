package acwing;
/*
 *
 *　　┏┓　　　┏┓+ +
 *　┏┛┻━━━┛┻┓ + +
 *　┃　　　　　　　┃
 *　┃　　　━　　　┃ ++ + + +
 *  ████━████+
 *  ◥██◤　◥██◤ +
 *　┃　　　┻　　　┃
 *　┃　　　　　　　┃ + +
 *　┗━┓　　　┏━┛
 *　　　┃　　　┃ + + + +Code is far away from
 *　　　┃　　　┃ + bug with the animal protecting
 *　　　┃　 　 ┗━━━┓ 神兽保佑,代码无bug
 *　　　┃ 　　　　　　 ┣┓
 *　　  ┃ 　　　　　 　┏┛
 *　    ┗┓┓┏━┳┓┏┛ + + + +
 *　　　　┃┫┫　┃┫┫
 *　　　　┗┻┛　┗┻┛+ + + +
 * */

import java.util.Arrays;
import java.util.Scanner;

public class Acwing1239 {
    static int n, k;
    static Scanner in = new Scanner(System.in);
    static int[] a = new int[100010];
    static int mod = 1000000009;

    public static void main(String[] args) {
        n = in.nextInt();
        k = in.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.sort(a, 0, n);
        long res = 1;
        int l = 0, r = n - 1;
        int sign = 1;
        if ((k & 1) == 1) {
            res *= a[r];
            r--;
            k--;
            if (res < 0) sign = -1;//如果最大值都是负数的话，那么全都是负数，答案一定为负数
        }
        while (k > 0) {
            long x = (long) ((long) a[l] * a[l + 1]), y = (long) ((long) a[r] * a[r - 1]);
            if (x * sign > y * sign) {
                res = (res % mod) * (x % mod);
                l += 2;
                k -= 2;
            } else {
                res = (res % mod) * (y % mod);
                r -= 2;
                k -= 2;
            }
            res %= mod;
        }
        System.out.println(res);

    }
}

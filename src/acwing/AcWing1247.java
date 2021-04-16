package acwing;

import java.util.Arrays;
import java.util.Scanner;

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
public class AcWing1247 {
    static int[] arr = new int[200010];
    static int n, m;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();
        int k = m + n + 1;
        for (int i = 1; i <= k; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr, 1, k + 1);
        long sum = 0;
        if (m == 0) {
            for (int x : arr) sum += x;
            System.out.println(sum);
            return;
        }
        sum += arr[k];
        sum -= arr[1];
        for (int i = 2; i < k; i++) {
            sum += Math.abs(arr[i]);
        }
        System.out.println(sum);
    }
}

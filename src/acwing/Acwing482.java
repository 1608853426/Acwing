package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Acwing482 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] high = reader.readLine().split(" ");
        int[] up = new int[n]; //up[i]为以第[i + 1]个成员为终点之前的最长上升序列长度
        int[] down = new int[n];//down[i]为以第[i + 1]个成员为起点之后的最长下降序列长度

        //求up[]
        for (int i = 0; i < n; i++) {
            up[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (Integer.parseInt(high[j]) < Integer.parseInt(high[i]))
                    up[i] = Math.max(up[i], up[j] + 1);
            }
        }

        //求down[]
        for (int i = n - 1; i >= 0; i--) {
            down[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (Integer.parseInt(high[j]) < Integer.parseInt(high[i]))
                    down[i] = Math.max(down[i], down[j] + 1);
            }
        }

        //求最长的上升下降序列长之和
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, down[i] + up[i] - 1);
        }
        System.out.println(n - ans);
    }
}

package acwing;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Acwing1353 {
    public static void main(String[] args) throws IOException {
        //读入所有山峰高度到一个Arraylist中
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }
        //排序山峰高度
        Collections.sort(list);
        //ans用来存每次枚举的最小值，sum用来存每次枚举需要削减的米数
        int ans = Integer.MAX_VALUE;
        for (int i = list.get(0); i <= list.get(n - 1); i++) {
            int sum = 0;
            for (int num : list) {
                if (num < i) sum += (i - num) * (i - num);
                if (num > (i + 17)) sum += (num - i - 17) * (num - i - 17);
            }

            ans = Math.min(ans, sum);
        }
        System.out.println(ans);
    }
}

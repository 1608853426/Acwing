package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class AcWing1603 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();
        String[] str = reader.readLine().split(" ");
        for (int i = 0; i < str.length; i++) {
            list.add(Integer.parseInt(str[i]));
        }
        Collections.sort(list);
        int ans1 = n & 1;
        int ans2 = get((n + 2) / 2, n, list) - get(1, n / 2, list);
        System.out.println(ans1 + " " + ans2);
    }

    static int get(int a, int b, ArrayList<Integer> list) {
        int res = 0;
        for (int i = a - 1; i < b; i++) {
            res += list.get(i);
        }
        return res;
    }
}

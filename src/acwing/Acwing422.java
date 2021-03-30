package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Acwing422 {
    private static final int N = 110;

    private static int l, n;
    private static int seg[][] = new int[N][2];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = reader.readLine().split(" ");
        l = Integer.parseInt(str1[0]);
        n = Integer.parseInt(str1[1]);
        for (int i = 0; i < n; i++) {
            String str2[] = reader.readLine().split(" ");
            seg[i][0] = Integer.parseInt(str2[0]);
            seg[i][1] = Integer.parseInt(str2[1]);
        }
        int ans = l + 1 - merge(seg);
        System.out.println(ans);
    }

    private static int merge(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        int res = 0;
        for (int i = 0; i < merged.size(); i++) {
            if (merged.get(i)[0] == 0 && merged.get(i)[1] == 0) continue;
            res += 1 + merged.get(i)[1] - merged.get(i)[0];
        }
        return res;
    }

}

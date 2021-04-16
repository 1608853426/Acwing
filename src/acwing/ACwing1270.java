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

import java.io.*;

public class ACwing1270 {
    private static final int N = 100010;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] w = new int[N];
    static Node[] tr = new Node[N * 4];
    static int n, m;

    public static void main(String[] args) throws IOException {
        String[] str;
        str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        str = reader.readLine().split(" ");
        for (int i = 1; i < n + 1; i++) {
            w[i] = Integer.parseInt(str[i - 1]);
        }
        build(1, 1, n);
        int l, r;
        for (int i = 0; i < m; i++) {
            str = reader.readLine().split(" ");
            l = Integer.parseInt(str[0]);
            r = Integer.parseInt(str[1]);
            writer.write(query(1, l, r) + "\n");
            writer.flush();
        }
        writer.close();
    }

    private static void build(int u, int l, int r) {
        if (l == r) tr[u] = new Node(l, r, w[r]);
        else {
            tr[u] = new Node(l, r, Integer.MIN_VALUE);
            int mid = l + r >> 1;
            build(u << 1, l, mid);
            build(u << 1 | 1, mid + 1, r);
            tr[u].maxv = Math.max(tr[u << 1].maxv, tr[u << 1 | 1].maxv);
        }

    }

    private static int query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) return tr[u].maxv;
        int mid = tr[u].l + tr[u].r >> 1;
        int maxv = Integer.MIN_VALUE;
        if (l <= mid) maxv = query(u << 1, l, r);
        if (r > mid) maxv = Math.max(maxv, query(u << 1 | 1, l, r));
        return maxv;
    }
}

class Node {
    int l, r;
    int maxv;

    public Node(int l, int r, int maxv) {
        this.l = l;
        this.r = r;
        this.maxv = maxv;
    }
}


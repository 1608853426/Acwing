package acwing;


import java.io.*;
import java.util.*;


public class AcWing_1101 {
    static int[][] dist = new int[210][210];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int r, c, ii, jj;
    static char[][] g;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String[] str = reader.readLine().split(" ");
            r = Integer.parseInt(str[0]);
            c = Integer.parseInt(str[1]);
            g = new char[r][c];
            for (int i = 0; i < r; i++) {
                String str1 = reader.readLine();
                for (int j = 0; j < c; j++) {
                    g[i][j] = str1.charAt(j);
                    if (g[i][j] == 'S') {
                        ii = i;
                        jj = j;
                    }
                }
            }
            bfs(ii, jj);
        }
    }

    private static void bfs(int ii, int jj) {
        Queue<AbstractMap.SimpleEntry<Integer, Integer>> queue = new ArrayDeque<>();
        queue.offer(new AbstractMap.SimpleEntry<>(ii, jj));
        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], -1);
        }
        dist[ii][jj] = 0;
        while (!queue.isEmpty()) {
            AbstractMap.SimpleEntry<Integer, Integer> t = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = t.getKey() + dx[i], y = t.getValue() + dy[i];
                if (x >= 0 && x < r && y >= 0 && y < c && g[x][y] != '#' && dist[x][y] == -1) {
                    dist[x][y] = dist[t.getKey()][t.getValue()] + 1;
                    if (g[x][y] == 'E') {
                        System.out.println(dist[x][y]);
                        return;
                    }
                    queue.offer(new AbstractMap.SimpleEntry<Integer, Integer>(x, y));
                }
            }
        }
        System.out.println("oop!");
    }

/*    private static void bfs(Pair<Integer, Integer> start) {
        Queue<Pair<Integer,Integer>> q = new LinkedList<Pair<Integer,Integer>>();
        q.offer(start);
        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], -1);
        }

        dist[start.getKey()][start.getValue()] = 0;
        while (!q.isEmpty()){
            Pair<Integer,Integer> t = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = t.getKey() + dx[i], y = t.getValue() + dy[i];
                if (x >= 0 && x < r && y >= 0 && y < c && g[x][y] != '#' && dist[x][y] == -1){
                    dist[x][y] = dist[t.getKey()][t.getValue()] + 1;
                    if (g[x][y] == 'E'){
                        System.out.println(dist[x][y]);
                        return;
                    }
                    q.offer(new Pair<>(x,y));
                }
            }
        }
        System.out.println("oop!");
    }*/
}

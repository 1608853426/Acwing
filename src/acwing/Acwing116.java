package acwing;

import java.io.*;
import java.util.*;

public class Acwing116 {
    static char[][] str = new char[5][5];
    static char[][] s = new char[5][5];
    static BufferedReader reader;


    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        //读入棋盘
        for (int i = 0; i < 4; i++) {
            str[i] = reader.readLine().toCharArray();
        }


        List<PII> res = new ArrayList<PII>();

        //
        for (int op = 0; op < (1 << 16); op++) {

            List<PII> ans = new ArrayList<PII>();
            for (int i = 0; i < 4; i++) {
                System.arraycopy(str[i], 0, s[i], 0, 4);
            }

            //进行操作
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (((op >> get(i, j)) & 1) == 1) {
                        ans.add(new PII(i, j));
                        turn_all(i, j);
                    }
                }
            }

            //判断所有灯泡是否全亮
            boolean isClosed = false;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (s[i][j] == '+') {
                        isClosed = true;
                        break;
                    }
                }
            }

            if (!isClosed) {
                if (res.isEmpty() || res.size() > ans.size()) {
                    res = new ArrayList<PII>(ans);
                }
            }
        }
        System.out.println(res.size());
        for (PII p : res) {
            int a = p.getXx() + 1;
            int b = p.getYy() + 1;
            System.out.println(a + " " + b);
        }

    }


    private static void turn_all(int x, int y) {
        // TODO Auto-generated method stub
        for (int i = 0; i < 4; i++) {
            turn_one(x, i);
            turn_one(i, y);
        }
        turn_one(x, y);
    }


    private static void turn_one(int x, int y) {
        // TODO Auto-generated method stub
        if (s[x][y] == '+') {
            s[x][y] = '-';
        } else {
            s[x][y] = '+';
        }
    }


    private static int get(int i, int j) {
        // TODO Auto-generated method stub
        return i * 4 + j;
    }

}

class PII {
    private int xx;
    private int yy;

    public PII(int xx, int yy) {
        this.xx = xx;
        this.yy = yy;
    }

    public int getYy() {
        return yy;
    }

    public void setYy(int yy) {
        this.yy = yy;
    }

    public int getXx() {
        return xx;
    }

    public void setXx(int xx) {
        this.xx = xx;
    }
}
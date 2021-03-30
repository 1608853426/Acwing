package acwing;

import java.io.*;

import static java.lang.Math.*;

public class Acwing1211 {
    static StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, temp, left, right = 0;

    public static void main(String[] args) throws IOException {
        //脑筋急转弯
        tokenizer.nextToken();
        n = (int) tokenizer.nval;
        tokenizer.nextToken();
        temp = (int) tokenizer.nval;

        while (n-- > 1) {
            tokenizer.nextToken();
            int x = (int) tokenizer.nval;
            //左边向右走
            if (abs(x) < abs(temp) && x > 0) left++;
            //右边向左走
            if (abs(x) > abs(temp) && x < 0) right++;
        }
        //特判
        if (temp > 0 && right == 0 || temp < 0 && left == 0) {
            writer.write(1 + "\n");
            writer.flush();
            return;
        }
        writer.write(left + right + 1 + "\n");
        writer.flush();
    }
}

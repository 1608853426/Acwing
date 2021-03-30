package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Acwing420 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        String[] str = reader.readLine().split(" ");
        int[] q = new int[n];
        for (int i = 0; i < str.length; i++) {
            q[i] = Integer.parseInt(str[i]);
        }
        while (m-- != 0) {
            next(q);
        }
        for (int i = 0; i < q.length; i++) {
            System.out.print(q[i] + " ");
        }
    }

    public static void next(int[] num) {
        if (num.length <= 1)
            return;
        for (int i = num.length - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                int j;
                for (j = num.length - 1; j >= i; j--)
                    if (num[i] < num[j])
                        break;
                // swap the two numbers.  
                num[i] = num[i] ^ num[j];
                num[j] = num[i] ^ num[j];
                num[i] = num[i] ^ num[j];
                //sort the rest of arrays after the swap point.  
                Arrays.sort(num, i + 1, num.length);
                return;
            }
        }
        //reverse the arrays.  
        for (int i = 0; i < num.length / 2; i++) {
            int tmp = num[i];
            num[i] = num[num.length - i - 1];
            num[num.length - i - 1] = tmp;
        }
        return;
    }
}

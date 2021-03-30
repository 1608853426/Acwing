package acwing;


import java.util.*;
import java.io.*;

public class AcWing1477 {
    static String[] map = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder(reader.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        int temp = 0;
        for (int i = 0; i < str.length(); i++) temp += (int) (str.charAt(i) - '0');
        if (temp == 0) stack.push(temp);
        while (temp != 0) {
            stack.push(temp % 10);
            temp /= 10;
        }
        while (!stack.empty()) {
            System.out.print(map[stack.pop()] + " ");
        }
    }
}


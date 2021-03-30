package acwing;

import java.io.*;
import java.util.*;

public class AcWing_425 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] str = reader.readLine().split(" ");
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < str.length; i++)
            if (!list.contains(Integer.parseInt(str[i]))) list.add(Integer.parseInt(str[i]));
        Collections.sort(list);
        System.out.println(list.size());
        System.out.println();
        for (int i : list)
            System.out.print(i + " ");
    }
}

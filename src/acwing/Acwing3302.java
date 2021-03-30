package acwing;

import java.io.*;
import javax.script.*;

public class Acwing3302 {

    static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String strs = reader.readLine();
        try {
            System.out.println(jse.eval(strs));
        } catch (Exception t) {
        }
    }
}
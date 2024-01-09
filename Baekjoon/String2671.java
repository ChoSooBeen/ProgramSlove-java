package Baekjoon;

import java.io.*;
import java.util.regex.Pattern;

public class String2671 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        if(Pattern.matches("^(100+1+|01)+$", input)) {
            bw.write("SUBMARINE");
        }
        else {
            bw.write("NOISE");
        }

        bw.flush();
        bw.close();
    }
}
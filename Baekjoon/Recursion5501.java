package Baekjoon;

import java.io.*;

public class Recursion5501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            String s = br.readLine();
            bw.write(solve(s, 0, s.length()-1, 1) + "\n");
        }
        bw.flush();
        bw.close();
    }
    public static String solve(String s, int l, int r, int count){
        if(l >= r) return 1 + " " + count;
        else if(s.charAt(l) != s.charAt(r)) return 0 + " " + count;
        else return solve(s, l+1, r-1, count+1);
    }
}

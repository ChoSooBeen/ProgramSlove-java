package Baekjoon;

import java.io.*;

public class Greedy2720 {
    public static int[] coin = {25, 10, 5, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int charge = Integer.parseInt(br.readLine());
            bw.write(solve(charge) + "\n");
        }
        bw.flush();
        bw.close();
    }
    public static String solve(int charge) {
        String result = "";
        for(int i = 0; i < 4; i++) {
            result += (charge / coin[i] + " ");
            charge %= coin[i];
        }
        return result;
    }
}

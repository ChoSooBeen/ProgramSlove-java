package Baekjoon;

import java.io.*;

public class Implement1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] n = br.readLine().strip().split("");
        int[] count = new int[10];
        for(int i = 0; i < n.length; i++) {
            int t = Integer.parseInt(n[i]);
            count[t] += 1;
        }
        count[6] += count[9];
        count[6] = count[6] % 2 == 0 ? count[6] / 2 : count[6] / 2 + 1;

        int max = 0;
        for(int i = 0; i < 9; i++) {
            max = Math.max(max, count[i]);
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
    }
}

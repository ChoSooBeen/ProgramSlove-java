package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class DP11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] card = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i-j] + card[j]);
            }
        }

        bw.write(dp[n] + "");
        bw.flush();
        bw.close();
    }
}

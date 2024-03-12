package Baekjoon;

import java.io.*;

public class DP11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long dp[][] = new long[n+1][10];

        for(int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = j; k < 10; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        bw.write((dp[n][0]) + "");
        bw.flush();
        bw.close();
    }
}

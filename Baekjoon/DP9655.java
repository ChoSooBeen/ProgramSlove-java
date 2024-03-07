package Baekjoon;

import java.io.*;

public class DP9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(implementFunc(n));
        bw.write(MathFunc(n));
        bw.write(DPFunc(n));
        bw.flush();
        bw.close();
    }

    /**
     * 게임 동작을 구현하는 방식
     */
    static String implementFunc(int n) {
        boolean flag = false; //true = SK, false = CY

        while(n > 0) {
            if(n >=3) {
                n -= 3;
            }
            else {
                n -= 1;
            }
            flag = !flag;
        }

        if(flag) {
            return "SK";
        }
        return "CY";
    }

    /**
     * 간단한 수학적인 성질을 이용한 방식
     */
    static String MathFunc(int n) {
        return n % 2 == 0 ? "CY" : "SK";
    }

    /**
     * DP를 이용한 방식
     */
    static String DPFunc(int n) {
        if(n < 4) {
            if(n % 2 == 0) {
                return "CY";
            }
            return "SK";
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;

        for(int i = 4; i <= n; i++) {
            dp[i] = Math.min(dp[i-1], dp[i-3]) + 1;
        }

        if(dp[n] % 2 == 0) {
            return "CY";
        }
        return "SK";
    }
}

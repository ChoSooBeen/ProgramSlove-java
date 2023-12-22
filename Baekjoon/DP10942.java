package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class DP10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[n];
        boolean[][] dp = new boolean[n][n]; //i-j까지의 수열이 팰린드롬이면 dp[i][j] = true
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            dp[i][i] = true; //길이가 1이면 무조건 팰린드롬
        }

        for(int i = 1; i < n; i++) { //길이가 2이면 두 수가 같아햐지만 팰린드롬
            if(nums[i-1] == nums[i]){
                dp[i-1][i] = true;
            }
        }

        //길이가 3이상인 수열인 경우
        for(int i = 2; i < n; i++) { //i = 수열 길이
            for(int j = 0; j < n-i; j++) { //j = 시작 인덱스
                if(nums[j] == nums[j+i] && dp[j+1][j+i-1]) dp[j][j+i] = true;
            }
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            if(dp[start][end]) bw.write(1+"\n");
            else bw.write(0+"\n");
        }
        bw.flush();
        bw.close();
    }
}
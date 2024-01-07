package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Greedy11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(t > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] cost = new int[n];
            for(int i = 0; i < n; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }
            bw.write(solve(cost) + "\n");
            t--;
        }

        bw.flush();
        bw.close();
    }

    public static long solve(int[] cost) {
        long answer = 0;
        int idx = cost.length-1;
        while(idx >= 0) {
            boolean flag = true;
            for(int i = idx-1; i >= 0; i--) {
                if(cost[idx] < cost[i]) {
                    idx = i;
                    flag = false;
                    break;
                }
                answer += (cost[idx] - cost[i]);
            }
            if(flag) break;
        }
        return answer;
    }
}

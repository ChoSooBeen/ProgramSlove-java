package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BinarySearch2512 {
    static int[] requests;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        requests = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = 0;
        for(int i = 0; i < n; i++) {
            requests[i] = Integer.parseInt(st.nextToken());
            sum += requests[i];
            max = Math.max(max, requests[i]);
        }

        int m = Integer.parseInt(br.readLine());

        if(sum <= m) { //요청 예산의 합이 전체 예산보다 작을 경우
            bw.write(max + ""); //가장 요청이 큰 액수에 맞춘다.
        }
        else {
            int current = m / n; //공평하게 나눴을 경우부터 탐색
            while(true) {
                if(solve(current) > m) break;
                current++;
            }

            bw.write(current - 1 + "");
        }
        bw.flush();
        bw.close();
    }

    static int solve(int current) {
        int answer = 0;
        for(int i = 0; i < requests.length; i++) {
            answer += current >= requests[i] ? requests[i] : current;
        }
        return answer;
    }
}

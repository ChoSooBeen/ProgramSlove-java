package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Greedy13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] students = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }
        bw.write(solve(students, n, k) + "");
        bw.flush();
        bw.close();
    }

    public static int solve(int[] student, int n, int k) {
        int[] diff = new int[n-1];
        for(int i = 1; i < n; i++) {
            diff[i-1] = student[i] - student[i-1];
        }

        Arrays.sort(diff);

        int answer = 0;
        for(int i = 0; i < n - k; i++) {
            answer += diff[i];
        }
        return answer;
    }
}

package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BrutueForce2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bw.write(solve(n, k) + "");
        bw.flush();
        bw.close();
    }

    static int solve(int n, int k) {
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                count++;
                if(count == k) {
                    return i;
                }
            }
        }
        return 0;
    }
}

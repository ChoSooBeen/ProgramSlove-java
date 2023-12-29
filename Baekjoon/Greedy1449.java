package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Greedy1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] leaks = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            leaks[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(leaks);

        int idx = 0;
        int count = 0;
        while(idx < n) {
            boolean flag = true;
            for(int i = idx+1; i < n; i++) {
                if(leaks[i] - leaks[idx] >= k) {
                    idx = i;
                    count++;
                    flag = false;
                    break;
                }
            }
            if(flag) {
                if(leaks[n-1] - leaks[idx] < k) {
                    idx = n;
                }
                else {
                    idx++;
                }
                count++;
            }
        }

        System.out.println(count);
    }
}

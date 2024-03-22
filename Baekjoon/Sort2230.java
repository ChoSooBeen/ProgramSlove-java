package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sort2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);
        int start = 0;
        int end = 0;
        int result = Integer.MAX_VALUE;
        while(end < n && start < n) {
            int c = array[end]-array[start];
            if(c >= m) {
                result = Math.min(result, c);
                start++;
            }
            else {
                end++;
            }

        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}

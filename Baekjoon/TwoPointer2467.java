package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoPointer2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(solution(array));
        bw.flush();
        bw.close();
    }

    public static String solution(int[] array) {
        Arrays.sort(array);
        int start = 0;
        int end = array.length-1;
        int min = Math.abs(array[start] + array[end]);
        int x = start, y = end;

        while(start < end && min != 0) {
            int currnet = array[start] + array[end];
            if(Math.abs(currnet) < min) {
                min = Math.abs(currnet);
                x = start;
                y = end;
            }

            if(currnet > 0) {
                end--;
            }
            else if(currnet < 0){
                start++;
            }
        }
        return array[x] + " " + array[y];
    }
}

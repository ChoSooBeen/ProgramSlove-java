package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Math1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            long start = Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken());
            bw.write(getCount(start, end) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int getCount(long start, long end) {
        long distance = end - start;
        int max = (int)Math.sqrt(distance); //이동거리의 최댓값

        if(max == Math.sqrt(distance)) {
            return 2 * max - 1;
        }

        if(distance <= max * max + max) {
            return 2 * max;
        }
        return 2 * max + 1;
    }
}

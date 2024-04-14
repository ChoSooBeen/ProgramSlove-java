package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Implement3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int[] x_idx = new int[3];
        int[] y_idx = new int[3];
        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            x_idx[i] = x;
            y_idx[i] = y;
        }
        bw.write(getIndex(x_idx) + " " + getIndex(y_idx));
        bw.flush();
        bw.close();
    }
    static int getIndex(int[] idx) {
        if(idx[0] == idx[1]) {
            return idx[2];
        }
        if(idx[0] == idx[2]) {
            return idx[1];
        }
        return idx[0];
    }
}

package SciOI2023;

import java.io.*;
import java.util.StringTokenizer;

public class A2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] tracks = new int[n];
        for(int i = 0; i < n; i++) {
            tracks[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for(int i = 1; i < n; i++) {
            if(tracks[i-1] < tracks[i]) continue;
            if(tracks[i-1] < tracks[i] + k) {
                count++;
                tracks[i] += k;
            }
            else {
                count = -1;
                break;
            }
        }
        System.out.println(count);
    }
}

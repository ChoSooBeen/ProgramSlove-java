package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Math2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());
        int[] sides = new int[6];
        int width = -1;
        int height = -1;
        for(int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            sides[i] = Integer.parseInt(st.nextToken());
            if(n < 3) {
                if(width == -1) {
                    width = i;
                }
                else if(sides[width] < sides[i]) {
                    width = i;
                }
            }
            else {
                if(height == -1) {
                    height = i;
                }
                else if(sides[height] < sides[i]) {
                    height = i;
                }
            }
        }

        int result = sides[width] * sides[height];
        int h = Math.abs(sides[(width+1) % 6] - sides[(6+(width-1)) % 6]);
        int w = Math.abs(sides[(height+1) % 6] - sides[(6+(height-1)) % 6]);
        result -= w * h;

        bw.write(result * k + "");
        bw.flush();
        bw.close();
    }
}

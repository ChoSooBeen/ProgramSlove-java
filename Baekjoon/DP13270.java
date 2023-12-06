package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class DP13270 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); //사람 수 (n >= 2)

        int a = 1; //1닭 -> 피보나치 수열의 첫번째 항
        int b = 2; //2인 - > 피보나치 수열의 두번째 항

        int[] min = new int[n+1]; //min[i] : i명일 때 최소의 치킨 수
        int[] max = new int[n+1]; //max[i] : i명일 때 최대의 치킨 수

        for(int i = 1; i <= n; i++) {
            min[i] = 987654321;
        }

        while(b <= n) {
//            bw.write("b = " + b + "\n");
            for(int i = b; i <= n; i++) {
                min[i] = Math.min(min[i], min[i-b] + a);
                max[i] = Math.max(max[i], max[i-b] + a);
//                bw.write("min : " + Arrays.toString(min) + "\t");
//                bw.write("max : " + Arrays.toString(max) + "\n");
            }
            int tmp = b;
            b += a;
            a = tmp;
        }
        bw.write(min[n] + " " + max[n]);
        bw.flush();
        bw.close();
    }
}

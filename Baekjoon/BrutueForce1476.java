package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BrutueForce1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken()); //15
        int s = Integer.parseInt(st.nextToken()); //28
        int m = Integer.parseInt(st.nextToken()); //19

        int year = 1;
        int E = 1, S = 1, M = 1;
        while(true) {
            if(E > 15) E = 1;
            if(S > 28) S = 1;
            if(M > 19) M = 1;
            if(E == e && S == s && M == m) {
                bw.write(year+"");
                break;
            }
            year++;
            E++;
            S++;
            M++;
        }

        bw.flush();
        bw.close();
    }
}

package SciOI2023;

import java.io.*;
import java.util.StringTokenizer;

public class A1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            bw.write(solve(n, m, k) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int solve(int n, int m, int k) {
        if(m == 1 && k == 1) { //우산이 1개이고 1명만 쓸 수 있다면
            if(n == 1) return 1; //사람이 1명이면 1번으로 가능
            return -1; //그 외에는 불가능
        }

        int count = 0;
        boolean umbrella = true; //우산이 창의 인재관에 있는지
        int destination = 0; //융합인재관에 있는 학생 수

        while(destination < n) {
            if(umbrella) {
                destination += m * k;
                umbrella = false;
            }
            else {
                destination -= 1;
                umbrella = true;
            }
            count++;
        }
        return count;
    }
}

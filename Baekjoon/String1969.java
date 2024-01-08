package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class String1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] dnas = new String[n];
        for (int i = 0; i < n; i++) {
            dnas[i] = br.readLine();
        }
        bw.write(solve(n, m, dnas));
        bw.flush();
        bw.close();
    }

    /**
     * Hamming Distance 가 가장 작은 DNA 구하기
     * @param n dna 개수
     * @param m dna 길이
     * @param dnas 입력받은 dna 배열
     * @return DNA 와 distance
     */
    public static String solve(int n, int m, String[] dnas) {
        char[] nucleotide = {'A', 'C', 'G', 'T'}; //사전순으로
        StringBuilder sb = new StringBuilder();
        int distance = 0;

        for(int i = 0; i < m; i++) { //i : 현재 탐색하고 있는 자릿수
            int[] count = new int[4];
            for(int j = 0; j < n; j++) { //j : 현재 탐색하고 있는 문자열
                char c = dnas[j].charAt(i);
                switch (c) {
                    case 'A': count[0] += 1; break;
                    case 'C' : count[1] += 1; break;
                    case 'G' : count[2] += 1; break;
                    default : count[3] += 1; break;
                }
            }

            int max = count[0];
            int idx = 0;
            for(int j = 1; j < 4; j++) {
                if(max < count[j]) {
                    idx = j;
                    max = count[j];
                }
            }
            sb.append(nucleotide[idx]);
            distance += (n-count[idx]);
        }

        return sb.append("\n" + distance).toString();
    }
}

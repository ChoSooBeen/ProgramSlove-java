package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Math27172 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = 1000001;
        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n];
        boolean[] players = new boolean[size]; //players[i] : i가 존재하는지 여부
        int[] result = new int[size]; //result[i] : i의 점수

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
            players[cards[i]] = true;
        }

        for(int card : cards) {
            //현재 card의 배수일 경우에만 나누어떨어지므로 이 수가 존재하는지 확인
            for(int i = card * 2; i < size; i += card) {
                if(players[i]) {
                    result[card] += 1;
                    result[i] -= 1;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            bw.write(result[cards[i]] + " ");
        }
        bw.flush();
        bw.close();
    }
}

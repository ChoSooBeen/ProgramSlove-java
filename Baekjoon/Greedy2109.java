package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Greedy2109 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] lectures = new int[n][2];
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
        }

        if(n == 0) {
            bw.write("0");
        }
        else {
            bw.write(solve(lectures) + "");
        }

        bw.flush();
        bw.close();
    }

    public static int solve(int[][] lectures) {
        Arrays.sort(lectures, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) return o2[0] - o1[0];
                return o2[1] - o1[1];
            }
        });

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int idx = 0;
        int pay = 0;
        for(int day = lectures[0][1]; day > 0; day--) {
            while(idx < lectures.length && lectures[idx][1] >= day) {
                heap.offer(-lectures[idx][0]);
                idx++;
            }
            if(!heap.isEmpty()) {
                pay -= heap.poll();
            }
        }
        return pay;
    }
}

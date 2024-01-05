package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Greedy13904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] assignments = new int[n][2];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            assignments[i][0] = Integer.parseInt(st.nextToken());
            assignments[i][1] = Integer.parseInt(st.nextToken());
        }
        System.out.println(getMaxScore(assignments));
    }

    public static int getMaxScore(int[][] assignments) {
        //마감일이 먼 것부터, 같으면 점수가 높을 것부터 정렬
        Arrays.sort(assignments, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o2[0] - o1[0] == 0) {
                    return o2[1] - o1[1];
                }
                return o2[0] - o1[0];
            }
        });

        PriorityQueue<Integer> heap = new PriorityQueue<>(); //최소힙이므로 점수를 음수로 입력한다.
        int score = 0;
        int idx = 0;
        for(int day = assignments[0][0]; day > 0; day--) {
            while (idx < assignments.length && assignments[idx][0] >= day) {
                heap.offer(-assignments[idx][1]);
                idx++;
            }
            if(!heap.isEmpty()) {
                score -= heap.poll(); //음수로 입력되었기 때문에 빼준다.
            }
        }
        return score;
    }
}

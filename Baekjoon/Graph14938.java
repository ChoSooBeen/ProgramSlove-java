package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Graph14938 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] items = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        int[][] ground = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j) {
                    ground[i][j] = 987654321;
                }
            }
        }
        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            ground[x-1][y-1] = w;
            ground[y-1][x-1] = w;
        }

        System.out.println(maxItems(ground, items, m));
    }

    /**
     * 얻을 수 있는 아이템의 최대 개수
     * @param ground 지역별 연결 배열
     * @param items 지역마다 아이템 개수 배열
     * @param m 수색 범위
     * @return 최댓값
     */
    public static int maxItems(int[][] ground, int[] items, int m) {
        //플로이드-워셜 알고리즘으로 지역별 죄단거리 구하기
        for(int k = 0; k < ground.length; k++) {
            for(int i = 0; i < ground.length; i++) {
                for(int j = 0; j < ground.length; j++) {
                    ground[i][j] = Math.min(ground[i][j], ground[i][k] + ground[k][j]);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < ground.length; i++) {
            int count = 0;
            for(int j = 0; j < ground.length; j++) {
                if(ground[i][j] <= m) { //수색범위 내의 지역일 경우 아이템 수집 가능
                    count += items[j];
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
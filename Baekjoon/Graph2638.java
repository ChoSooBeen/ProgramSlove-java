package Baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph2638 {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        int cheese = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1) {
                    cheese++;
                }
            }
        }
        int time = 0;
        while(cheese > 0) {
            time++;
            air();
            cheese -= melting();
        }
        System.out.println(time);
    }

    /**
     * BFS로 구현
     * 외부 공기 판별 -> 2로 변경
     * 모눈종이의 맨 가장자리에는 치즈가 놓이지 않는 것으로 가정
     */
    public static void air() {
        int n = graph.length;
        int m = graph[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(0, 0));
        visited[0][0] = true;
        graph[0][0] = 2;

        while(!queue.isEmpty()) {
            Point current = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if(visited[nx][ny] || graph[nx][ny] == 1) {
                    continue;
                }
                queue.offer(new Point(nx, ny));
                visited[nx][ny] = true;
                graph[nx][ny] = 2;
            }
        }
    }

    /**
     * 치즈 녹이는 함수
     * @return 녹인 치즈의 개수
     */
    public static int melting() {
        int n = graph.length;
        int m = graph[0].length;

        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(graph[i][j] != 1) {
                    continue;
                }
                int c = 0;
                for(int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                        continue;
                    }
                    if(graph[nx][ny] == 2) {
                        c++;
                    }
                }
                if(c >= 2) {
                    count++;
                    graph[i][j] = 0;
                }
            }
        }
        return count;
    }
}

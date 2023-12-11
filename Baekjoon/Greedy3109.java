package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Greedy3109 {
    public static int[][] dir = {{-1, 1}, {0, 1}, {1, 1}};
    public static char[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        graph = new char[r][c];
        for(int i = 0; i < r; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        int count = 0;
        for(int i = 0; i < r; i++) {
            if(DFS(i, 0))
                count++;
        }

        System.out.println(count);
    }

    /**
     * 파이프 연결 가능 판별
     * @param x 현재 행
     * @param y 현재 열
     * @return 연결 가능하면 ture, 아니면 false
     */
    public static boolean DFS(int x, int y) {
        graph[x][y] = '-'; //확인 완료된 좌표

        if(y == graph[0].length-1) { //내 빵집까지 도달했을 경우
            return true;
        }
        for(int i = 0; i < 3; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(nx < 0 || nx >= graph.length || ny < 0 || ny >= graph[0].length) {
                continue;
            }
            if(graph[nx][ny] == '.') {
                if(DFS(nx, ny))
                    return true;
            }
        }
        return false;
    }
}

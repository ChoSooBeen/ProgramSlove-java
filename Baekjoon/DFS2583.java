package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class DFS2583 {
    static int[][] graph;
    static int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        graph = new int[m][n];
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());
            for(int a = lx; a < rx; a++) {
                for(int b = ly; b < ry; b++) {
                    graph[b][a] = 1;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(graph[i][j] == 0) {
                    result.add(dfs(i, j));
                }
            }
        }
        Collections.sort(result);
        bw.write(result.size() + "\n");
        for(int i = 0; i < result.size(); i++) {
            bw.write(result.get(i) + " ");
        }
        bw.flush();
        bw.close();
    }

    static int dfs(int x, int y) {
        graph[x][y] = 2;
        int count = 1;
        for(int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(nx < 0 || nx >= graph.length || ny < 0 || ny >= graph[0].length)
                continue;
            if(graph[nx][ny] == 0) {
                count += dfs(nx, ny);
            }
        }
        return count;
    }
}

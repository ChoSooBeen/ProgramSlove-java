package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DFS2644 {
    static LinkedList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        graph = new LinkedList[n+1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        visited = new boolean[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].offer(y);
            graph[y].offer(x);
        }

        bw.write(dfs(s, e, 0) + "");
        bw.flush();
        bw.close();
    }

    static int dfs(int s, int e, int count) {
        visited[s] = true;
        if(s == e) return count;

        int answer = -1;
        for(int i = 0; i < graph[s].size(); i++) {
            if(!visited[graph[s].get(i)]) {
                answer = Math.max(answer, dfs(graph[s].get(i), e, count + 1));
            }
        }

        return answer;
    }
}